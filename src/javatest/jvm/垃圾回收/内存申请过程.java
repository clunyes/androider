package javatest.jvm.垃圾回收;

public class 内存申请过程 {
    /**
     *
     * 内存申请过程
     *     1. JVM会试图为相关Java对象在Eden中初始化一块内存区域；
     *     2. 当Eden空间足够时，内存申请结束。否则到下一步；
     *     3. JVM试图释放在Eden中所有不活跃的对象（minor collection），释放后若Eden空间仍然不足以放入新对象，则试图将部分Eden中活跃对象放入Survivor区；
     *     4. Survivor区被用来作为Eden及old的中间交换区域，当old区空间足够时，Survivor区的对象会被移到Old区，否则会被保留在Survivor区；
     *     5. 当old区空间不够时，JVM会在old区进行major collection；
     *     6. 完全垃圾收集后，若Survivor及old区仍然无法存放从Eden复制过来的部分对象，导致JVM无法在Eden区为新对象创建内存区域，则出现"Out of memory错误"；
     */
}
