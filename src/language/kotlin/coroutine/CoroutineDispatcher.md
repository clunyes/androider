CoroutineContext 包含一个 CoroutineDispatcher（协程调度器）用于指定执行协程的目标载体，即 运行于哪个线程。
CoroutineDispatcher 可以将协程的执行操作限制在特定线程上，也可以将其分派到线程池中，或者让它无限制地运行。
所有的协程构造器（如 launch 和 async）都接受一个可选参数，即 CoroutineContext ，
该参数可用于显式指定要创建的协程和其它上下文元素所要使用的 CoroutineDispatcher.



Kotlin 协程库提供了四个 Dispatcher 用于指定在哪一类线程中执行协程：

1. Dispatchers.Default。默认调度器，适合用于执行占用大量 CPU 资源的任务。例如：对列表排序和解析 JSON
2. Dispatchers.IO。适合用于执行磁盘或网络 I/O 的任务。例如：使用 Room 组件、读写磁盘文件，执行网络请求
3. Dispatchers.Unconfined。对执行协程的线程不做限制，可以直接在当前调度器所在线程上执行
4. Dispatchers.Main。使用此调度程序可用于在 Android 主线程上运行协程，只能用于与界面交互和执行快速工作，例如：更新 UI、调用 LiveData.setValue
