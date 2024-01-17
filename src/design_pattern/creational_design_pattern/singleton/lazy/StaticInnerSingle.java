package design_pattern.creational_design_pattern.singleton.lazy;

/**
 * 静态内部类 ，单例
 */
public class StaticInnerSingle {
    private StaticInnerSingle() {
    }

    private static class SingletonPatternHolder {
        private static final StaticInnerSingle singletonPattern = new StaticInnerSingle();
    }

    public static StaticInnerSingle getInstance() {
        return SingletonPatternHolder.singletonPattern;
    }
}
