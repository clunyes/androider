package sourcecode.okhttp;

public class okhttpconnectionReuse {
    /**
     * 客户端和服务器建立socket连接需要经历TCP的三次握手和四次挥手，是一种比较消耗资源的动作。
     *
     * Http中有一种keepAlive connections的机制，在和客户端通信结束以后可以保持连接指定的时间。
     * OkHttp3支持5个并发socket连接，默认的keepAlive时间为5分钟。
     *
     * ConnectionPool里的几个重要变量：

     *（1）executor线程池，类似于CachedThreadPool，用于执行清理空闲连接的任务。
     *（2）Deque双向队列，同时具有队列和栈的性质，经常在缓存中被使用，里面维护的RealConnection是socket物理连接的包装
     *（3）RouteDatabase，用来记录连接失败的路线名单
     *
     *
     * 总结

     *（1）OkHttp3中支持5个并发socket连接，默认的keepAlive时间为5分钟，当然我们可以在构建OkHttpClient时设置不同的值。

     *（2）OkHttp3通过Deque<RealConnection>来存储连接，通过put、get等操作来管理连接。

     *（3）OkHttp3通过每个连接的引用计数对象StreamAllocation的计数来回收空闲的连接，向连接池添加新的连接时会触发执行清理空闲连接的任务。清理空闲连接的任务通过线程池来执行。
     */
}
