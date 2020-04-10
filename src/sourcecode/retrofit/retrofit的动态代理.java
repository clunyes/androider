package sourcecode.retrofit;

public class retrofit的动态代理 {
    /**
     * sApiCommonService = sRetrofit.create(ApiCommonService.class);
     *
     */
//    public <T> T create(final Class<T> service) {
//        //省略一些判断代码
//        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[] { service },
//                new InvocationHandler() {
//                    private final Platform platform = Platform.get();
//
//                    @Override public Object invoke(Object proxy, Method method, @Nullable Object[] args)
//                            throws Throwable {
//                        //这里才是我们重点关注的地方：
//                        ServiceMethod<Object, Object> serviceMethod =
//                                (ServiceMethod<Object, Object>) loadServiceMethod(method);
//                        OkHttpCall<Object> okHttpCall = new OkHttpCall<>(serviceMethod, args);
//                        return serviceMethod.callAdapter.adapt(okHttpCall);
//                    }
//                });
//    }


//    ServiceMethod<?, ?> loadServiceMethod(Method method) {
//        ServiceMethod<?, ?> result = serviceMethodCache.get(method);
//        if (result != null) return result;
//
//        synchronized (serviceMethodCache) {
//            result = serviceMethodCache.get(method);
//            if (result == null) {
//                result = new ServiceMethod.Builder<>(this, method).build();
//                serviceMethodCache.put(method, result);
//            }
//        }
//        return result;
//    }

    /**
     * 1. 采用builder方式去构建ServiceMethod
     * 2. 其中解析方法注解
     * 3. 其中解析参数注解
     * 4. 再对特定的注解进行判断（multipart至少要有一个part）
     * 5. 最后用serviceMethod生成okHttpCall
     */
}
