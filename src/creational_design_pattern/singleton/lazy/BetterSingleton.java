package creational_design_pattern.singleton.lazy;

//这种比上面1、2都好一些，既实现了线程安全，又避免了同步带来的性能影响。
public class BetterSingleton {
    /**
     * 至于1、2、3这三种实现又有些区别，
     * 第1种，在方法调用上加了同步，虽然线程安全了，但是每次都要同步，会影响性能，毕竟99%的情况下是不需要同步的，
     * 第2种，在getInstance中做了两次null检查，确保了只有第一次调用单例的时候才会做同步，这样也是线程安全的，同时避免了每次都同步的性能损耗
     * 第3种，利用了classloader的机制来保证初始化instance时只有一个线程，所以也是线程安全的，同时没有性能损耗，所以一般我倾向于使用这一种。
     */
    private static class LazyHolder {
        private static final BetterSingleton INSTANCE = new BetterSingleton();
    }

    private BetterSingleton() {
    }

    public static final BetterSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
