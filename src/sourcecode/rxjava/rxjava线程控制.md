# rxjava线程控制
**RxJava线程控制：**想切换线程，需要使用Scheduler

1）Scheduler.immediate()：直接在当前线程运行，它是timeout、timeInterval和timeStamp操作符的默认调度器

2）Schedulers.newThread()：总是启用新线程，并在新线程执行操作

3）Schedulers.io()：I/O操作所使用的Scheduler

4）Schedulers.computation()：计算所使用的Scheduler

5）Schedulers.trampoline()：当我们想在当前线程执行一个任务时，并不是立即时，可以用.trampoline()将它入列

6）AndroidSchedulers.mainThread()：RxAndroid库中提供的Scheduler，它指定的操作在主线程中运行