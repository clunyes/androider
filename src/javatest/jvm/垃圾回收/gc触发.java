package javatest.jvm.垃圾回收;

public class gc触发 {
    /**
     * 新生代GC（Minor GC）：指发生在新生代的垃圾收集动作，因为Java对象大多都具备朝生夕灭的特性，
     * 所以Minor GC非常频繁，一般回收速度也比较快。
     *
     * 老年代GC（Major GC / Full GC）：指发生在老年代的GC，出现了Major GC，经常会伴随至少一次的Minor GC
     * （但非绝对的，在Parallel Scavenge收集器的收集策略里就有直接进行Major GC的策略选择过程）。
     * Major GC的速度一般会比Minor GC慢10倍以上。
     */
    /**
     * Minor GC
     *
     * Minor GC：当Eden区所剩空间，不满足分配需求时，就会触发Minor GC。
     */
    /**
     * Full GC
     *
     *     1. 当进行Minor GC时，会预测老年代能否承受得住新生代晋升的空间，预测的行为是对比当前老年代所剩空间大小和以往Minor GC平均晋升空间大小或者对比当前老年代所剩空间大小和年轻代存活对象总空间
     *     （二者是或的关系，成立一个即可），大于的话，预测是可以通过的，就只进行一次Minor GC。小于的话，预测是无法通过的，就要进行一次Full GC，
     *     对整个堆进行一次回收（其中也会包括对Eden、Survivor区的回收），当然我理解，本次Minor GC也就被Full GC代替。
     *     以上只是预测，实际情况还可能出现预测大于，实际小于的情况，这种情况下就会出现【担保失败】的情况，还会引发一次Full GC。
     *
     *     2. 永久代(或者可是说是方法区的实现)满了，也会触发full gc
     *
     */
}
