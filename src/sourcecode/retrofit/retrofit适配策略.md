# retrofit适配策略
适配的代码在HttpServiceMethod

```Plain Text
private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(
    Retrofit retrofit, Method method, Type returnType, Annotation[] annotations) {
  try {
    //noinspection unchecked
    return (CallAdapter<ResponseT, ReturnT>) retrofit.callAdapter(returnType, annotations);
  } catch (RuntimeException e) { // Wide exception range because factories are user code.
    throw methodError(method, e, "Unable to create call adapter for %s", returnType);
  }
}

private static <ResponseT> Converter<ResponseBody, ResponseT> createResponseConverter(
    Retrofit retrofit, Method method, Type responseType) {
  Annotation[] annotations = method.getAnnotations();
  try {
    return retrofit.responseBodyConverter(responseType, annotations);
  } catch (RuntimeException e) { // Wide exception range because factories are user code.
    throw methodError(method, e, "Unable to create converter for %s", responseType);
  }
}
```
CallAdapter继续

```Plain Text
#Retrofit.class

public CallAdapter<?, ?> callAdapter(Type returnType, Annotation[] annotations) {
        return nextCallAdapter(null, returnType, annotations);
}

public CallAdapter<?, ?> nextCallAdapter(
            @Nullable CallAdapter.Factory skipPast, Type returnType, Annotation[] annotations) {
        int start = callAdapterFactories.indexOf(skipPast) + 1;
        for (int i = start, count = callAdapterFactories.size(); i < count; i++) {
            //通过returnType在callAdapterFactories获取adapter工厂，再get adapter
            CallAdapter<?, ?> adapter = callAdapterFactories.get(i).get(returnType, annotations, this);
            if (adapter != null) {
                return adapter;
            }
        }
        ...

```


先通过`returnType`在`callAdapterFactories`获取adapter工厂，再通过工厂`get()`获取`CallAdapter`实例。
`callAdapterFactories`是`3.1`结尾`build()`中初始化的，通过`platform`添加默认类型，
也可以通过`addCallAdapterFactory()`添加`RxJava`之类的适配器类型。

这里用到了两个设计模式`适配器`跟`策略`

```Plain Text
适配器模式
ReturnT、ResponseT引入适配器模式可以让结果更加灵活
```
返回的`CallAdapter`其实就是`Call<T>`的适配器，假如你想让`Retrofit`配合`RxJava`使用，
常规方式只能在业务中单独创建`Observable`并与`Call`融合，关于`Observable`与`Call`融合(适配)其实是与业务无关的，
此时可以引入适配器模式将`Call`适配成`Observable`，将适配细节从业务层挪到`Retrofit`内部，符合`迪米特法则`

```Plain Text
策略模式
```
通过`ReturnT`获取对应的`CallAdapter`，如果`ReturnT`是`Call<T>`那获取的是`DefaultCallAdapterFactory`创建的实例，
如果是`Observable<T>`则获取的是`RxJava2CallAdapterFactory`创建的实例。
假如想新增一种适配器只需明确`ReturnT`，创建对应工厂再通过`addCallAdapterFactory`添加即可，
`Retrofit`会通过`ReturnT`自动寻找对应`CallAdapter`，符合`开闭原则(扩展开放)`

```Plain Text
创建responseConverter
```
关于`responseConverter`其实是做数据转换的，可以将`ResponseT`适配成我们想要的数据类型，
比如`Gson`解析只需通过`addConverterFactory`添加`GsonConverterFactory`创建的`Converter`实例即可 
具体添加、获取流程与`CallAdapter`基本一致。



calladapter实现在retrofit-adapters模块中，responseConverter实现在retrofit-converters模块中。







