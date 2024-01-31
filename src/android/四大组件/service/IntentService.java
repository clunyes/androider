package android.四大组件.service;

public class IntentService {
    /**
     *
     * 1. IntentService 是继承自 Service 并处理异步请求的一个类，在 IntentService 内有一个工作线程来处理耗时操作。
     * 2. 当任务执行完后，IntentService 会自动停止，不需要我们去手动结束。
     * 3. 如果启动 IntentService 多次，那么每一个耗时操作会以工作队列的方式在 IntentService 的 onHandleIntent 回调方法中执行，
     * 依次去执行，使用串行的方式，执行完自动结束。
     *
     *
     * 默认开启子线程的service
     * onHandleIntent处理client传过来的intent
     *
     */
}
