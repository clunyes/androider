coroutineScope 函数用于创建一个独立的协程作用域，直到所有启动的协程都完成后才结束自身。
runBlocking 和 coroutineScope 看起来很像，因为它们都需要等待其内部所有相同作用域的协程结束后才会结束自己。
两者的主要区别在于 runBlocking 方法会阻塞当前线程，而 coroutineScope不会，而是会挂起并释放底层线程以供其它协程使用。
基于这个差别，runBlocking 是一个普通函数，而 coroutineScope 是一个挂起函数