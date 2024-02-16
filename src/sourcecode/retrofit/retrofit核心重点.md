# retrofit核心重点
动态代理，在service执行请求时，动态代理执行逻辑入口

```Plain Text
public <T> T create(final Class<T> service) {
  validateServiceInterface(service);
  return (T)
      Proxy.newProxyInstance(
          service.getClassLoader(),
          new Class<?>[] {service},
          new InvocationHandler() {
            private final Object[] emptyArgs = new Object[0];

            @Override
            public @Nullable Object invoke(Object proxy, Method method, @Nullable Object[] args)
                throws Throwable {
              // If the method is a method from Object then defer to normal invocation.
              if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, args);
              }
              args = args != null ? args : emptyArgs;
              Platform platform = Platform.get();
              return platform.isDefaultMethod(method)
                  ? platform.invokeDefaultMethod(method, service, proxy, args)
                  : loadServiceMethod(method).invoke(args);
            }
          });
}
```


调用路径如下两段代码

```Plain Text
ServiceMethod<?> loadServiceMethod(Method method) {
  ServiceMethod<?> result = serviceMethodCache.get(method);
  if (result != null) return result;

  synchronized (serviceMethodCache) {
    result = serviceMethodCache.get(method);
    if (result == null) {
      result = ServiceMethod.parseAnnotations(this, method);
      serviceMethodCache.put(method, result);
    }
  }
  return result;
}
```


```Plain Text
abstract class ServiceMethod<T> {
  static <T> ServiceMethod<T> parseAnnotations(Retrofit retrofit, Method method) {
    RequestFactory requestFactory = RequestFactory.parseAnnotations(retrofit, method);

    Type returnType = method.getGenericReturnType();
    if (Utils.hasUnresolvableType(returnType)) {
      throw methodError(
          method,
          "Method return type must not include a type variable or wildcard: %s",
          returnType);
    }
    if (returnType == void.class) {
      throw methodError(method, "Service methods cannot return void.");
    }

    return HttpServiceMethod.parseAnnotations(retrofit, method, requestFactory);
  }

  abstract @Nullable T invoke(Object[] args);
```
RequestFactory requestFactory = RequestFactory.parseAnnotations(retrofit, method);

是重点之一，作用是将方法上的注解逐一解析



```Plain Text
static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(
    Retrofit retrofit, Method method, RequestFactory requestFactory) {
  boolean isKotlinSuspendFunction = requestFactory.isKotlinSuspendFunction;
  boolean continuationWantsResponse = false;
  boolean continuationBodyNullable = false;
  boolean continuationIsUnit = false;

  Annotation[] annotations = method.getAnnotations();
  Type adapterType;
  if (isKotlinSuspendFunction) {
    Type[] parameterTypes = method.getGenericParameterTypes();
    Type responseType =
        Utils.getParameterLowerBound(
            0, (ParameterizedType) parameterTypes[parameterTypes.length - 1]);
    if (getRawType(responseType) == Response.class && responseType instanceof ParameterizedType) {
      // Unwrap the actual body type from Response<T>.
      responseType = Utils.getParameterUpperBound(0, (ParameterizedType) responseType);
      continuationWantsResponse = true;
    } else {
      continuationIsUnit = Utils.isUnit(responseType);
      // TODO figure out if type is nullable or not
      // Metadata metadata = method.getDeclaringClass().getAnnotation(Metadata.class)
      // Find the entry for method
      // Determine if return type is nullable or not
    }

    adapterType = new Utils.ParameterizedTypeImpl(null, Call.class, responseType);
    annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
  } else {
    adapterType = method.getGenericReturnType();
  }

  CallAdapter<ResponseT, ReturnT> callAdapter =
      createCallAdapter(retrofit, method, adapterType, annotations);
  Type responseType = callAdapter.responseType();
  if (responseType == okhttp3.Response.class) {
    throw methodError(
        method,
        "'"
            + getRawType(responseType).getName()
            + "' is not a valid response body type. Did you mean ResponseBody?");
  }
  if (responseType == Response.class) {
    throw methodError(method, "Response must include generic type (e.g., Response<String>)");
  }
  // TODO support Unit for Kotlin?
  if (requestFactory.httpMethod.equals("HEAD")
      && !Void.class.equals(responseType)
      && !Utils.isUnit(responseType)) {
    throw methodError(method, "HEAD method must use Void or Unit as response type.");
  }

  Converter<ResponseBody, ResponseT> responseConverter =
      createResponseConverter(retrofit, method, responseType);

  okhttp3.Call.Factory callFactory = retrofit.callFactory;
  if (!isKotlinSuspendFunction) {
    return new CallAdapted<>(requestFactory, callFactory, responseConverter, callAdapter);
  } else if (continuationWantsResponse) {
    //noinspection unchecked Kotlin compiler guarantees ReturnT to be Object.
    return (HttpServiceMethod<ResponseT, ReturnT>)
        new SuspendForResponse<>(
            requestFactory,
            callFactory,
            responseConverter,
            (CallAdapter<ResponseT, Call<ResponseT>>) callAdapter);
  } else {
    //noinspection unchecked Kotlin compiler guarantees ReturnT to be Object.
    return (HttpServiceMethod<ResponseT, ReturnT>)
        new SuspendForBody<>(
            requestFactory,
            callFactory,
            responseConverter,
            (CallAdapter<ResponseT, Call<ResponseT>>) callAdapter,
            continuationBodyNullable,
            continuationIsUnit);
  }
}
```
该方法主要处理了kotlin协程，以及请求返回类型的适配，实现适配的是callAdapter，responseConverter。

适配的介绍在[[retrofit适配策略 id=6ceaf967-100c-4450-b313-c243c024b5ed]]

loadServiceMethod(method).invoke(args)，invoke的调用轨迹callAdapter.adapt(call)，ExecutorCallbackCall，OkHttpCall。

```Plain Text
@Override
final @Nullable ReturnT invoke(Object[] args) {
  Call<ResponseT> call = new OkHttpCall<>(requestFactory, args, callFactory, responseConverter);
  return adapt(call, args);
}
```
与OkHttp对应也有enqueue异步，execute同步两种调用方式，而内部的实现则是Okhttp的call，所以说retrofit是封装了Okhttp。

```Plain Text
@Override
public void enqueue(final Callback<T> callback) {
  Objects.requireNonNull(callback, "callback == null");

  okhttp3.Call call;
  Throwable failure;

  synchronized (this) {
    if (executed) throw new IllegalStateException("Already executed.");
    executed = true;

    call = rawCall;
    failure = creationFailure;
    if (call == null && failure == null) {
      try {
        call = rawCall = createRawCall();
      } catch (Throwable t) {
        throwIfFatal(t);
        failure = creationFailure = t;
      }
    }
  }

  if (failure != null) {
    callback.onFailure(this, failure);
    return;
  }

  if (canceled) {
    call.cancel();
  }

  call.enqueue(
      new okhttp3.Callback() {
        @Override
        public void onResponse(okhttp3.Call call, okhttp3.Response rawResponse) {
          Response<T> response;
          try {
            response = parseResponse(rawResponse);
          } catch (Throwable e) {
            throwIfFatal(e);
            callFailure(e);
            return;
          }

          try {
            callback.onResponse(OkHttpCall.this, response);
          } catch (Throwable t) {
            throwIfFatal(t);
            t.printStackTrace(); // TODO this is not great
          }
        }

        @Override
        public void onFailure(okhttp3.Call call, IOException e) {
          callFailure(e);
        }

        private void callFailure(Throwable e) {
          try {
            callback.onFailure(OkHttpCall.this, e);
          } catch (Throwable t) {
            throwIfFatal(t);
            t.printStackTrace(); // TODO this is not great
          }
        }
      });
}

```


```Plain Text
@Override
public Response<T> execute() throws IOException {
  okhttp3.Call call;

  synchronized (this) {
    if (executed) throw new IllegalStateException("Already executed.");
    executed = true;

    call = getRawCall();
  }

  if (canceled) {
    call.cancel();
  }

  return parseResponse(call.execute());
}
```
两者最终都会parseResponse来适配我们在service中定义的返回值



```Plain Text
Response<T> parseResponse(okhttp3.Response rawResponse) throws IOException {
  ResponseBody rawBody = rawResponse.body();

  // Remove the body's source (the only stateful object) so we can pass the response along.
  rawResponse =
      rawResponse
          .newBuilder()
          .body(new NoContentResponseBody(rawBody.contentType(), rawBody.contentLength()))
          .build();

  int code = rawResponse.code();
  if (code < 200 || code >= 300) {
    try {
      // Buffer the entire body to avoid future I/O.
      ResponseBody bufferedBody = Utils.buffer(rawBody);
      return Response.error(bufferedBody, rawResponse);
    } finally {
      rawBody.close();
    }
  }

  if (code == 204 || code == 205) {
    rawBody.close();
    return Response.success(null, rawResponse);
  }

  ExceptionCatchingResponseBody catchingBody = new ExceptionCatchingResponseBody(rawBody);
  try {
    T body = responseConverter.convert(catchingBody);
    return Response.success(body, rawResponse);
  } catch (RuntimeException e) {
    // If the underlying source threw an exception, propagate that rather than indicating it was
    // a runtime exception.
    catchingBody.throwIfCaught();
    throw e;
  }
}
```
