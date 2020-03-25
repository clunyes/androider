package javatest.collection;

import java.util.HashMap;

public class hashmaptest {
    /**
     *
     * 一个数组，数组里存的链表
     *
     * HashMap的主干是一个Entry数组。Entry是HashMap的基本组成单元，每一个Entry包含一个key-value键值对，hash值，下一个entry节点（构成单向链表）。
     * HashMap采用Entry数组来存储key-value对，每一个键值对组成了一个Entry实体，Entry类实际上是一个单向的链表结构，它具有Next指针，
     * 可以连接下一个Entry实体，依次来解决Hash冲突的问题，因为HashMap是按照Key的hash值来计算Entry在HashMap中存储的位置的，如果hash值相同，而key内容不相等，那么就用链表来解决这种hash冲突。
     *
     * 根据代码i去数组上找，如果有相同entry，替换，没有，加入链表
     *
     *
     * 红黑树是JDK8中对hashmap作的一个变更，在JDK7之前，HashMap采用数组+链表的形式存储数据，我们知道优秀的hash算法应避免碰撞的发生,
     * 但假如开发者使用了不合适的hash算法，O(1)级别的数组查询会退化到O(n)级链表查询，因此在JDK8中引入红黑树的，当一个结点的链表长度大于8时，
     * 链表会转换成红黑树，提高查询效率,而链表长度小于6时又会退化成链表
     *
     * https://www.cnblogs.com/chengxiao/p/6059914.html
     */

//    int hash = hash(key.hashCode());//对key的hashcode进一步计算，确保散列均匀
//    int i = indexFor(hash, table.length);//获取在table中的实际位置

    //先用hashcode来找到数组中的位置。在链表中，仍需遍历链表，然后通过key对象的equals方法逐一比对查找
    /**
     * 线程安全的集合
     *
     * hashtable：方法上加锁，性能不好
     * ConcurrentHashMap：实现线程安全的思想也已经完全变了，它摒弃了Segment（锁段）的概念，
     * 而是启用了一种全新的方式实现,利用CAS算法。它沿用了与它同时期的HashMap版本的思想，
     * 底层依然由“数组”+链表+红黑树的方式思想，但是为了做到并发，又增加了很多辅助的类，例如TreeBin，Traverser等对象内部类。
     *
     * CopyOnWriteArrayList：加了写锁的ArrayList，锁住的是整个对象，但读操作可以并发执行
     * 如果有多个调用者（callers）同时请求相同资源（如内存或磁盘上的数据存储），
     * 他们会共同获取相同的指针指向相同的资源，直到某个调用者试图修改资源的内容时，
     * 系统才会真正复制一份专用副本（private copy）给该调用者，而其他调用者所见到的最初的资源仍然保持不变。
     * 优点是如果调用者没有修改该资源，就不会有副本（private copy）被建立，因此多个调用者只是读取操作时可以共享同一份资源。
     *
     */
}
