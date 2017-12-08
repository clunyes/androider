package creational_design_pattern.singleton.hungry;

public class Singleton {
    private Singleton() {
    }

    private static final Singleton single = new Singleton();

    //静态工厂方法
    public static Singleton getInstance() {
        return single;
    }
}
