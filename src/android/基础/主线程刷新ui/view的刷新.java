package android.基础.主线程刷新ui;

public class view的刷新 {
    /**
     * 就是当View的刷新操作触发时，会统一先注册到ViewRootImpl中；
     * 屏幕每隔16.6ms触发一次刷新，这个信号会通知ViewRootImpl进行UI刷新，
     * 然后在ViewRootImpl中实际执行View的测量，绘制的一系列操作。
     *
     * 多线程做刷新，view的绘制就会混乱
     */
}
