package java.collection;

import java.util.HashMap;

public class hashmaptest {
    /**
     * https://www.cnblogs.com/chengxiao/p/6059914.html
     *
     * 一个数组，数组里存的链表
     *
     * 根据代码i去数组上找，如果有相同entry，替换，没有，加入链表
     *
     */

//    int hash = hash(key.hashCode());//对key的hashcode进一步计算，确保散列均匀
//    int i = indexFor(hash, table.length);//获取在table中的实际位置

    //先用hashcode来找到数组中的位置。在链表中，仍需遍历链表，然后通过key对象的equals方法逐一比对查找
    /**
     * 线程安全的集合
     *
     * hashtable：方法上加锁，性能不好
     * ConcurrentHashMap：分段锁，锁的粒度比较小（也就是Segment锁，每个Segment含有整个table的一部分，这样不同分段之间的并发操作就互不影响 ）
     * CopyOnWriteArrayList：加了写锁的ArrayList，锁住的是整个对象，但读操作可以并发执行
     */
}
