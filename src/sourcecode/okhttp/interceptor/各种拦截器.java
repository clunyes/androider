package sourcecode.okhttp.interceptor;

public class 各种拦截器 {

    /**
     *
     *
     * RetryAndFollowUpInterceptor：在连接失败后进行重新连接，必要时进行重定向，如果调用被取消，可能会抛出IOException
     * BridgeInterceptor：构建访问网络的桥梁，首先，将用户请求转换成网络请求，然后访问网络，最后将网络响应转换成用户响应。
     * CacheInterceptor：缓存拦截器，从缓存中获取服务器请求，或者把服务器响应写入缓存中。
     * ConnectInterceptor：打开一个连接，去连接目标服务器。
     * CallServerInterceptor：拦截器链中的最后一个链点，通过网络请求服务器
     *
     */

}
