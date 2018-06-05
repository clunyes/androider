package creational_design_pattern.singleton.lazy;

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
}
