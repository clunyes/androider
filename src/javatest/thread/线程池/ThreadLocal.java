package javatest.thread.线程池;

public class ThreadLocal {
    /**
     * ThreadLocal是一个本地线程副本变量工具类。主要用于将私有线程和该线程存放的副本对象做一个映射，
     * 各个线程之间的变量互不干扰，在高并发场景下，可以实现无状态的调用，特别适用于各个线程依赖不同的变量值完成操作的场景。
     *
     *
     * android handler使用了这个类
     *
     * Looper 在构造时同步会创建 MessageQueue，并利用 ThreadLocal 这种 TLS，将其与当前线程绑定。（TLS ： Thread Local Storage）
     *
     * 其中ThreadLocalMap类的定义是在ThreadLocal类中，真正的引用却是在Thread类中。
     * Map的key是ThreadLocal类的实例对象，value为用户的值
     */
}
