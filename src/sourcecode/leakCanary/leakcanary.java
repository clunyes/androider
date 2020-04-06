package sourcecode.LeakCanary;

public class leakcanary {
    /**
     *
     * LeakCanary 是怎么实现的？
     *
     *
     * LeakCanary通过ApplicationContext统一注册监听的方式(registerActivityLifecycleCallbacks)，来监察所有的Activity生命周期，
     * 并在Activity的onDestroy时，执行RefWatcher的watch方法，该方法的作用就是检测本页面内是否存在内存泄漏问题。
     *
     *
     * 以上是检测的核心代码实现，从源码可以看出，检测的流程：
     * 1） 移除不可达引用，如果当前引用不存在了，则不继续执行
     * 2） 手动触发GC操作，gcTrigger中封装了gc操作的代码 
     * 3） 再次移除不可达引用，如果引用不存在了，则不继续执行
     * 4） 如果两次判定都没有被回收，则开始分析这个引用，最终生成HeapDump信息
     *
     * 1. 弱引用与ReferenceQueue联合使用，如果弱引用关联的对象被回收，则会把这个弱引用加入到ReferenceQueue中；
     * 通过这个原理，可以看出removeWeaklyReachableReferences()执行后，会对应删除KeyedWeakReference的数据。
     * 如果这个引用继续存在，那么就说明没有被回收。
     *
     * 2. 为了确保最大保险的判定是否被回收，一共执行了两次回收判定，包括一次手动GC后的回收判定。
     * 两次都没有被回收，很大程度上说明了这个对象的内存被泄漏了，但并不能100%保证；因此LeakCanary是存在极小程度的误差的。
     *
     *
     * humpHeap :  这个方法是生成一个文件，来保存内存分析信息
     * analyze: 执行分析
     *
     *
     *
     */

}
