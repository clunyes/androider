Handler 是标准的事件驱动模型，存在一个消息队列 MessageQueue，它是一个基于消息触发时间的优先级队列，
还有一个基于此消息队列的事件循环 Looper，Looper 通过循环，不断的从 MessageQueue 中取出待处理的 Message，
再交由对应的事件处理器 Handler/callback 来处理。

其中 MessageQueue 被 Looper 管理，Looper 在构造时同步会创建 MessageQueue，
并利用 ThreadLocal 这种 TLS，将其与当前线程绑定。而 App 的主线程在启动时，
已经构造并准备好主线程的 Looper 对象，开发者只需要直接使用即可。

Handler 类中封装了大部分「Handler 机制」对外的操作接口，
可以通过它的 send/post 相关的方法，向消息队列 MessageQueue 中插入一条 Message。
在 Looper 循环中，又会不断的从 MessageQueue 取出下一条待处理的 Message 进行处理。

当MQ没有消息时，线程进入阻塞态，减少消耗。