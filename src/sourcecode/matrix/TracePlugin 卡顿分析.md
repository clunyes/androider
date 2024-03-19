1. UIThreadMonitor：一个监听 UI 线程的监视器，监听什么内容？怎么监听？后面会给出答案。
2. 追踪器开始工作：TracePlugin 包含的四大追踪器，是实际的工作者。 
3. 线程检查：监视器和追踪器等需要在主线程进行初始化，所以分为两种情况：
当前在主线程下：直接调用 Runnable 对象的 run() 方法执行初始化；
当前不在主线程：使用 MatrixHandlerThread 中的主线程 Handler post 任务，切换到主线程执行初始化。




