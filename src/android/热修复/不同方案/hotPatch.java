package android.热修复.不同方案;

public class hotPatch {
    /**
     * 底层替换方案限制颇多，但时效性最好，加载轻快，立即见效。(函数hook，替换)
     *
     * 类加载方案时效性差，需要重新冷启动才能见效，但修复范围广，限制少。(dex替换)
     */
    /**
     * 目前热修复框架主要有QQ空间补丁、HotFix、Tinker、Robust等。热修复框架按照原理大致可以分为两种：
     *
     *  1. ClassLoader 加载方案
     *  2. Native层替换方案
     *
     * QQ空间补丁和Tinker都是使用的方案一； 阿里的AndFix使用的是方案二； 美团的Robust使用的是方案三。
     *
     * 考虑到 QZone 超级补丁未开源，阿里的 AndFix 也不再维护，我们从 Tinker、Robust、Sophix 中选择适合的方案使用。
     */
}
