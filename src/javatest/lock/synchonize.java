package javatest.lock;

public class synchonize {
    /**
     * 在 Java 早期版本中，synchronized属于重量级锁，效率低下
     * JDK 1.6 对synchronized同步锁做了的优化,目前比lock效率不差
     *
     * 锁的状态总共有四种，无锁状态、偏向锁、轻量级锁和重量级锁。随着锁的竞争，锁可以从偏向锁升级到轻量级锁，再升级的重量级锁，但是锁的升级是单向的，
     * 也就是说只能从低到高升级，不会出现锁的降级
     */

    /**
     * 引入偏向锁是为了在无多线程竞争的情况下尽量减少不必要的轻量级锁执行路径
     */
    /**
     * synchronized关键字的作用域有二种：
     *
     * 1. 某个对象实例内，synchronized aMethod(){}可以防止多个线程同时访问这个对象的synchronized方法（如果一个对象有多个synchronized方法，
     * 只要一个线程访问了其中的一个synchronized方法，其它线程不能同时访问这个对象中任何一个synchronized方法）。这时，不同的对象实例的 synchronized方法是不相干扰的。
     * 也就是说，其它线程照样可以同时访问相同类的另一个对象实例中的synchronized方法；
     *
     * 2. 某个类的范围，synchronized static aStaticMethod{}防止多个线程同时访问这个类中的synchronized static 方法。它可以对类的所有对象实例起作用。
     * 如下，method1和method2是一样的，类锁
     *
     * method3和method4是一样，对象锁
     * synchronized的缺陷：
     * 举个例子：当有多个线程读写文件时，读操作和写操作会发生冲突现象，写操作和写操作会发生冲突现象，但是读操作和读操作不会发生冲突现象。
     * 但是采用synchronized关键字来实现同步的话，就会导致一个问题：
     * 如果多个线程都只是进行读操作，所以当一个线程在进行读操作时，其他线程只能等待无法进行读操作。
     * 因此就需要一种机制来使得多个线程都只是进行读操作时，线程之间不会发生冲突，通过Lock就可以办到。
     * 另外，通过Lock可以知道线程有没有成功获取到锁。这个是synchronized无法办到的。
     *
     */

    static void method1() {
        synchronized (synchonize.class) {

        }
    }

    static synchronized void method2() {

    }

    void method3() {
        synchronized (this) {

        }
    }

    synchronized void method4() {

    }

}
