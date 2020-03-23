package javatest.collection;

import java.util.concurrent.ConcurrentHashMap;

public class collectiontest {
    /**
     *  这个类用以说明java集合的知识
     * 1. collection
     * 1. list必须保持元素特定的顺序
     * 2. set不能有重复元素
     * 3. queue保持一个队列(先进先出)的顺序
     * 2. map一组成对的"键值对"对象
     *
     * 1. HashSet hash即散列，散列即无序
     * 2. LinkedHashSet 有序的散列set
     * 3. TreeSet 树结构的set，有序

     * 1. ArrayList 线程不安全 查询高效（对于linkedlist）
     * 2. Vector 线程安全(stack)
     * 3. LinkedList c 插入高效（对于arraylist）

     * 1. queue 队列
     * 2. deque 双端队列
     */

    /**
     * * 1. hashmap
     * 2. hashtable 线程安全，键值都不能为null
     * 3. linkedHashmap 是HashMap的一个子类，如果需要输出的顺序和输入的相同,那么用LinkedHashMap可以实现,它还可以按读取顺序来排列，像连接池中可以应用。
     * 4. treeMap  取出来的是排序后的键值对。但如果您要按自然顺序或自定义顺序遍历键，那么TreeMap会更好。
     * 一般情况下，我们用的最多的是HashMap,HashMap里面存入的键值对在取出的时候是随机的,它根据键的HashCode值存储数据,根据键可以直接获取它的值，具有很快的访问速度。
     * 在Map 中插入、删除和定位元素，HashMap 是最好的选择。
     */
}
