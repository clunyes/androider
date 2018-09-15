package sourcecode.okhttp;

public class okhttprequest {

    /**
     * 异步请求
     * mOkHttpClient.newCall(request).enqueue(callback);
     * 同步请求
     * mOkHttpClient.newCall(request).execute();
     *
     * 所以我们发起请求无论是调用execute方法还是enqueue方法，实际上调用的都是RealCall内部的方法。
     *
     * 在RealCall内部的enqueue方法和execute方法中，都是通过OkHttpClient的任务调度器Dispatcher来完成。
     *
     * Dispatcher：我们如果需要用自己的线程池，可以调用带有线程池参数的构造方法。
     * Dispatcher中的默认构造方法是个空实现，线程池的加载方式采用的是懒加载，也就是在第一次调用请求的时候初始化。
     * Dispatcher采用的线程池类似于CacheThreadPool，没有核心线程，非核心线程数很大，比较适合执行大量的耗时较少的任务。
     *
     * 同步请求不会用到线程池
     * 异步请求用到线程池
     */
}
