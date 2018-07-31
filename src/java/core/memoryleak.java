package java.core;

public class memoryleak {
    /**
     * 1. 内部类
     * 2. handler（Thread）使用static+WeakReference的方式断开handler与activity的关系，static的handler类，类内部持有activity的弱引用对象。
     * 3. 单例模式，持有非application的context
     * 4. 静态集合，手动clear，置空
     */
    /**
     * mat
     * leakcanary 都可以检测解决该类问题
     */
}
