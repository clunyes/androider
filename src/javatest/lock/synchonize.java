package javatest.lock;

public class synchonize {
    /**
     * 锁的分类
     * 1.可重入锁：获得锁后，调用其他方法不比重复获取锁
     * 2.可中断锁：synchronized不可中断，lock可以中断
     * 3.公平锁：等待最久的线程先获得锁
     * 4.读写锁：读锁和写锁分开
     */
    /**
     * synchronized关键字的作用域有二种：
     *
     * 1. 某个对象实例内，synchronized aMethod(){}可以防止多个线程同时访问这个对象的synchronized方法（如果一个对象有多个synchronized方法，
     * 只要一个线 程访问了其中的一个synchronized方法，其它线程不能同时访问这个对象中任何一个synchronized方法）。这时，不同的对象实例的 synchronized方法是不相干扰的。
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
     * ReentrantLock,lock的唯一实现类
     * 附上lock接口
     * public interface Lock {
     * void lock();
     * void lockInterruptibly() throws InterruptedException;
     * boolean tryLock();
     * boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
     * void unlock();
     * Condition newCondition();
     * }
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
