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
}
