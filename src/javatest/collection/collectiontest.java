package javatest.collection;

import java.util.Vector;
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
     * 1. List和Set是存储单列数据的集合，Map是存储键和值这样的双列数据的集合；
     * 2. List中存储的数据是有顺序，并且允许重复； Map中存储的数据是无序的，其键是不能重复的，
     * 但是值是可以重复的；Set中存储的数据是无序的，且不允许有重复，但元素在集合中的位置由元素的hashCode决定，
     * 3. 位置是固定的（Set 根据hashcode来进行数据的存储，所以位置是固定的，但是位置不是用户可以控制的，
     * 所以对于用户来说 set 中的元素还是无序的）；
     */
}
