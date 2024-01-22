package javatest.thread.线程池;

public class threadpooltype {
    /**
     * https://www.jianshu.com/p/d82238a96064 线程的一些问题
     */
    /**
     * 1.newCachedThreadPool
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。

     这种类型的线程池特点是：

     工作线程的创建数量几乎没有限制(其实也有限制的,数目为Interger. MAX_VALUE), 这样可灵活的往线程池中添加线程。
     如果长时间没有往线程池中提交任务，即如果工作线程空闲了指定的时间(默认为1分钟)，则该工作线程将自动终止。终止后，如果你又提交了新的任务，则线程池重新创建一个工作线程。
     在使用CachedThreadPool时，一定要注意控制任务的数量，否则，由于大量线程同时运行，很有会造成系统瘫痪。
     *
     * 2.newFixedThreadPool
     *创建一个指定工作线程数量的线程池。每当提交一个任务就创建一个工作线程，如果工作线程数量达到线程池初始的最大数，则将提交的任务存入到池队列中。
     FixedThreadPool是一个典型且优秀的线程池，它具有线程池提高程序效率和节省创建线程时所耗的开销的优点。但是，在线程池空闲时，即线程池中没有可运行任务时，
     它不会释放工作线程，还会占用一定的系统资源。
     *
     * 3.newSingleThreadExecutor
     *
     * 创建一个单线程化的Executor，即只创建唯一的工作者线程来执行任务，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     * 如果这个线程异常结束，会有另一个取代它，保证顺序执行。单工作线程最大的特点是可保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程是活动的。
     *
     * 4. newScheduleThreadPool
     *
     * 创建一个定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行。
     *
     * 5. newWorkStealingPool（核心思想是:自己的活干完了去看看别人有没有没干完的活，如果有就拿过来帮他干。）
     * 这个是 JDK1.8 版本加入的一种线程池，它实现的一个线程池和上面4种都不一样，用的是 ForkJoinPool 类
     *
     * 参考资料：https://www.cnblogs.com/zhujiabin/p/5404771.html
     */
    /**
     * 1) FixedThreadPool 和 SingleThreadPool ： 允许的请求队列长度为
     *      *      Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM；
     *      *  2) CachedThreadPool 和 ScheduledThreadPool ： 允许的创建线程数量为
     *      *       Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
     */
}
