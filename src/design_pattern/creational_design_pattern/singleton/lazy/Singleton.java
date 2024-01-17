package design_pattern.creational_design_pattern.singleton.lazy;

public class Singleton {
    private static Singleton single = null;

    private Singleton() {

    }

    public static Singleton getSingleton() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }

    //在getInstance方法上加同步
    public static synchronized Singleton getSingleton2() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }

    /**
     * Double Check Lock 双重检查锁定
     *
     * DCL并不是十分稳定的，由于java编译器允许处理器乱序执行，所以这样做是有隐患的。
     * 简单说，其实new对象的操作不是原子性的。
     *
     * 问题出在，线程1在执行new的时候重排了指令，导致极端情况下，线程2获取的单例没有初始化完成
     * @return
     */
    public static Singleton getSingleton03() {
        if (single == null) {
            synchronized (Singleton.class) {
                if (single == null) {
                    single = new Singleton();
                }
            }
        }
        return single;
    }


    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */

    private static class SingletonInstance {
        /**
         * 由jvm保证线程安全
         */
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
