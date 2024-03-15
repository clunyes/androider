协程是轻量级的线程。
```
kotlin的协程本质上仍然是基于java线程实现，并不会在性能上超越java线程，与别的语言的协程不一样。
```
协程还是可以异步执行可挂起，但不影响线程中其他操作，切换消耗很小，线程状态切换消耗大。

协程的四个基础概念：

1. suspend function。即挂起函数，delay() 就是协程库提供的一个用于实现非阻塞式延时的挂起函数
2. CoroutineScope。即协程作用域，GlobalScope 是 CoroutineScope 的一个实现类，用于指定协程的作用范围，
可用于管理多个协程的生命周期，所有协程都需要通过 CoroutineScope 来启动
3. CoroutineContext。即协程上下文，包含多种类型的配置参数。Dispatchers.IO 就是 CoroutineContext 这个抽象概念的一种实现， 
用于指定协程的运行载体，即用于指定协程要运行在哪类线程上
4. CoroutineBuilder。即协程构建器，协程在 CoroutineScope 的上下文中通过 launch、async 等协程构建器来进行声明并启动。
launch、async 均被声明为 CoroutineScope 的扩展方法

协程底层通过状态机实现

```
fun main() = runBlocking { // this: CoroutineScope
    launch { doWorld() }
    println("Hello")
}

// this is your first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}
```
