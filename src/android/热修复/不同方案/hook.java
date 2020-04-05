package android.热修复.不同方案;

public class hook {
    /**
     *
     * hook的一些注意点
     * 怎么hook：hook使用java 反射机制，和动态代理来完成
     *
     *     1.寻找 Hook 点，原则是静态变量或者单例对象，尽量 Hook public 的对象和方法。
     *     2.选择合适的代理方式，如果是接口可以用动态代理。
     *     3.偷梁换柱——用代理对象替换原始对象。
     *
     * hook的问题：做好android api的兼容工作
     */
}
