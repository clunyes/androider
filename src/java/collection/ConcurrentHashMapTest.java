package java.collection;

public class ConcurrentHashMapTest {
    /**
     * hashtable 基本被废弃
     *
     * ConcurrentHashMap 采用分段锁
     *
     * hashtable锁粗粒度
     *
     * ConcurrentHashMap是conccurrent家族中的一个类，由于它可以高效地支持并发操作，以及被广泛使用，经典的开源框架Spring的底层数据结构就是使用ConcurrentHashMap实现的。
     * https://blog.csdn.net/jianghuxiaojin/article/details/52006118#commentBox 这篇文章自己分析了ConcurrentHashMap
     *
     * CAS算法实现无锁化的修改值的操作，他可以大大降低锁代理的性能消耗。
     * 这个算法的基本思想就是不断地去比较当前内存中的变量值与你指定的一个变量值是否相等，如果相等，则接受你指定的修改的值，否则拒绝你的操作。
     * 因为当前线程中的值已经不是最新的值，你的修改很可能会覆盖掉其他线程修改的结果。这一点与乐观锁，SVN的思想是比较类似的。
     */
}
