package sourcecode.okhttp.interceptor;

public class okhttpintercept {
    /**
     * 我们分析到不论是同步还是异步请求，都是通过RealCall内部的getResponseWithInterceptorChain方法来执行具体的网络连接的
     *
     * getResponseWithInterceptorChain方法中添加了一系列的拦截器Interceptor，包括用户的拦截器等。
     * 然后调用了RealInterceptorChain的proceed方法。每个拦截器都有特定的作用，通过责任链模式，每个拦截器完成自己的任务后，不断调用下个拦截器，最后完成网络请求。
     *
     * 内部interceptor分类：
     * 1. networkInterceptor
     * 2. interceptor
     * 这两个什么区别？
     *
     * ApplicationInterceptor(应用拦截器)
     * NetworkInterceptor（网络拦截器）
     　　他们的异同：

     　　相同点，

     　　1）都能对server返回的response进行拦截（好像是废话···）

        2）这两种拦截器本质上都是基于Interceptor接口，由开发者实现这个接口，然后将自定义的Interceptor类的对象设置到okhttpClient对象中。所以，他们的对象，本质上没什么不同，都是Interceptor的实现类的对象。

     　　3）两者都会被add到OkHttpClient内的一个ArrayList中。当请求执行的时候，多个拦截器会依次执行（list本身就是有序的）。

     　　不同点，

     　　1）okhttpClient添加两种拦截器的api不同。添加应用拦截器的接口是addInterceptor()，而添加网络拦截器的接口是addNetworkInterceptor().

     　　 2）两者负责的区域不同，从最上方图中可以看出，应用拦截器作用于okhttpCore到Application之间，网络拦截器作用于 network和okhttpCore之间

     　　 3）在某种特殊情况下（比如：访问了一个url，结果这个url发生了重定向），网络拦截器有可能被执行多次，但是 不论任何情况，application只会被执行一次。
     *
     * 源码实现的Interceptor
     * RetryAndFollowUpInterceptor：负责失败自动重连和必要的重定向。
     * BridgeInterceptor：负责将用户的Request转换成一个实际的网络请求Request，再调用下一个拦截器获取Response，然后将Response转换成用户的Response。
     * CacheInterceptor：负责控制缓存，缓存的逻辑就在这里面。
     * ConnectInterceptor：负责进行连接主机，在这里会完成socket连接，并将连接返回。
     * CallServerInterceptor：和服务器通信，完成Http请求。
     * 这些都是okhttp库内部定义的拦截器，不做修改
     *
     */

    /**
     * 缓存策略
     * Cache内部是通过DiskLruCache来实现缓存的，缓存的key就是request的URL的md5值，缓存的值就是Response
     */
}
