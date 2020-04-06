package javatest.jvm.垃圾回收;

public class gc收集器 {
    /**
     * 1、并行与并发：
     *
     * 并行（Parallel）：指多条垃圾收集线程并行工作，但此时用户线程仍然处于等待状态。
     *
     * 并发（Concurrent）：指用户线程与垃圾收集线程同时执行（但不一定是并行的，可能会交替执行），
     * 用户程序在继续运行，而垃圾收集程序运行于另一个CPU上。
     */
    /**
     * 1.serial收集器
     * 单线程，工作时必须暂停其他工作线程。多用于client机器上，使用复制算法
     * 2.ParNew收集器
     * serial收集器的多线程版本，server模式下虚拟机首选的新生代收集器。复制算法
     * 3.Parallel Scavenge收集器
     * 复制算法，可控制吞吐量的收集器。吞吐量即有效运行时间。
     * 4.Serial Old收集器
     * serial的老年代版本，使用整理算法。
     * 5.Parallel Old收集器
     * Parallel Scavnge的老年代版本，多线程，标记整理
     * 6.CMS收集器(Concurrent Mark Sweep)
     * 目标是最短回收停顿时间。标记清除算法实现，分四个阶段：
     *
     *     初始标记：GC Roots直连的对象做标记
     *     并发标记：多线程方式GC Roots Tracing
     *     重新标记：修正第二阶段标记的记录
     *     并发清除。
     *
     * 缺点：标记清除算法的缺点，产生碎片。CPU资源敏感。
     *
     * 7. G1收集器(服务端收集器)
     * 老年代收集器
     */
}
