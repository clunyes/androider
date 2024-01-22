## async
async 也是一个作用于 CoroutineScope 的扩展函数，和 launch 的区别主要就在于：async 可以返回协程的执行结果，而 launch 不行

```
public fun <T> CoroutineScope.async(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
): Deferred<T>

```

通过await()方法可以拿到 async 协程的执行结果，可以看到两个协程的总耗时是远少于七秒的，总耗时基本等于耗时最长的协程