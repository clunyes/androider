首先来看一个最简单的Http请求是如何发送的。

```
val okHttpClient = OkHttpClient()
val request: Request = Request.Builder().url("https://www.google.com/").build()
okHttpClient.newCall(request).enqueue(object : Callback {
    overridefunonFailure(call:Call,e:IOException) {}
    overridefunonResponse(call:Call,response:Response) {}
})
```

OkHttp请求过程中最少只需要接触OkHttpClient、Request、Call、 Response，但是框架内部会进行大量的逻辑处理。

分发器：内部维护队列与线程池，完成请求调配；

拦截器：五大默认拦截器完成整个请求过程。
1. 通过建造者模式构建OKHttpClient与 Request
2. OKHttpClient通过newCall发起一个新的同步或者异步请求
3. 通过分发器维护请求队列与线程池，完成请求调配
4. 通过五大默认拦截器完成请求重试，缓存处理，建立连接等一系列操作
5. 得到网络请求结果