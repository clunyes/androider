package javatest.jvm.内存结构;

public class java堆 {
    /**
     *
     * 堆内存中对象的分配的基本策略
     *
     * Java堆分为年轻代（Young Generation）和老年代（Old Generation）；
     * 年轻代又分为伊甸园（Eden）和幸存区（Survivor区）；幸存区又分为From Survivor空间和 To Survivor空间
     *
     *
     * 老年代存储长期存活的对象和大对象。年轻代中存储的对象，经过多次GC后仍然存活的对象会移动到老年代中进行存储。
     * 老年代空间占满后，会触发Full GC。
     *
     * 注：Full GC是清理整个堆空间，包括年轻代和老年代。如果Full GC之后，堆中仍然无法存储对象，就会抛出OutOfMemoryError异常。
     */

    /**
     * Minor Gc和Full GC 有什么不同呢？
     * 大多数情况下，对象在新生代中 eden 区分配。当 eden 区没有足够空间进行分配时，虚拟机将发起一次Minor GC。
     * 新生代GC（Minor GC）:指发生新生代的的垃圾收集动作，Minor GC非常频繁，回收速度一般也比较快。
     * 老年代GC（Major GC/Full GC）:指发生在老年代的GC，出现了Major GC经常会伴随至少一次的Minor GC（并非绝对），Major GC的速度一般会比Minor GC的慢10倍以上。
     *

     */
}
