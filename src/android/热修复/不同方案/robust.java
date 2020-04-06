package android.热修复.不同方案;

public class robust {
    /**
     * 动态插桩，在每个类中注入一个静态变量、在每个方法前插入控制逻辑
     * Robust 与 Tinker 正好相反，它的定位是热修复，不支持 so替换、资源替换，立即生效，且成功率非常高。
     *
     * 采用了instant run的热插拔启动原理
     *
     * 做一些业务逻辑的热修复比较适合
     *
     */
}
