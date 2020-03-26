package javatest.jvm;

public class memoryleak {
    /**
     * 完全垃圾收集后(full gc)，若Survivor及old区仍然无法存放从Eden复制过来的部分对象，导致JVM无法在Eden区为新对象创建内存区域，则出现"Out of memory错误"；
     */
    /**
     * 1. 内部类
     * 2. handler（Thread）使用static+WeakReference的方式断开handler与activity的关系，static的handler类，类内部持有activity的弱引用对象。
     * 3. 单例模式，持有非application的context(context合理使用)
     * 4. 静态集合，手动clear，置空
     */
    /**
     * mat
     * leakcanary 都可以检测解决该类问题
     */

    /**
     * 几乎所有的 OOM 错误都是因为宿主应用出了问题，而不是 Glide 本身。 应用里两种常见的 OOM 错误分别是：
     *
     * 过大的内存分配 (Excessively large allocations)
     * 内存泄露(Memory leaks, 被分配的内存没有被释放)
     */
}
