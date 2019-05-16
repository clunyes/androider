package newtech;

public class hotPatch {
    /**
     * classLoader：
     * 1.PathClassLoader:加载系统类和应用类
     * 2.DexClassLoader:加载jar、apk、dex文件
     *
     * 如果不考虑增大apk的体积，只是简单的修复代码，不修复so和资源，选择Robust是最稳定的，否则的话选择Tinker是一个不错的方案。
     * 虽然阿里Sophix横空出世，但是它不开源，而且商业收费，所以一般不是很赚钱的app选择收费的可能就很小了。
     * 不过它确实各方面都做了大量的优化，本文中的很多知识点也来源于阿里的《Android热修复技术原理.pdf》一书，本书值得一读，里面就是基于Sophix框架来编排的。
     *
     * instant run:
     * 构建修改的部分 → 部署修改的dex或资源 → 热部署，温部署，冷部署
     * 热拔插：代码改变被应用、投射到APP上，不需要重启应用，不需要重建当前activity。
     * 场景：适用于多数的简单改变（包括一些方法实现的修改，或者变量值修改）
     * 温拔插：activity需要被重启才能看到所需更改。
     * 场景：典型的情况是代码修改涉及到了资源文件，即resources。
     * 冷拔插：app需要被重启（但是仍然不需要重新安装）
     * 场景：任何涉及结构性变化的，比如：修改了继承规则、修改了方法签名等。
     *
     * api hook：改变API执行结果的技术
     *
     * 1. robust：Instant Run 热插拔原理，为每个class都增加了一个类型为ChangeQuickRedirect的静态成员，来判断是否需要调用补丁包
     * 2. tinker：获取差异化dex，与原来dex，合并成merge.dex，再插入
     * 3. sophix：
     * 做到了优化，
     * 1. andfix优化升级
     * 2. 全量dex优化版本
     *
     *
     * 4. andfix/Dexposed：原理如下，native层获取到指定方法的结构体，修改内部逻辑，再回调java。问题，兼容性差，不同厂家对android进行修改。
     直接在native层进行方法的结构体信息对换，从而实现完美的方法新旧替换，从而实现热修复功能

     他的思想完全来源于Xposed框架，完美诠释了AOP编程，这里用到最核心的知识点就是在native层获取到指定方法的结构体，
     然后改变他的nativeFunc字段值，而这个值就是可以指定这个方法对应的native函数指针，所以先从Java层跳到native层，改变指定方法的nativeFunc值，
     然后在改变之后的函数中调用Java层的回调即可。实现了方法的拦截功能。基于开源框架Xposed实现，是一种AOP解决方案
     只Hook App本身的进程，不需要Root权限
     *
     */
}
