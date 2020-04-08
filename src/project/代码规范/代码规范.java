package project.代码规范;

public class 代码规范 {
    /**
     * 1. 资源命名规范
     * 2. 新建线程时，必须通过线程池提供，不允许在应用中自行显式创建线程。
     * 3. 线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方
     * 式，Executors创建的现有的线程池有oom风险
     *  1) FixedThreadPool 和 SingleThreadPool ： 允许的请求队列长度为
     *      Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM；
     *  2) CachedThreadPool 和 ScheduledThreadPool ： 允许的创建线程数量为
     *       Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
     * 4. 不要硬编码文件路径，请使用 Android 文件系统 API 访问。
     *
     */
}
