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

    //双重检查锁定
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
