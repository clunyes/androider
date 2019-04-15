package java.lock;

public class lock {
    /**
     * 衍生 乐观锁，悲观锁
     *
     * 基于CAS的自旋就是典型的乐观锁：该算法涉及三个数：内存值V，旧的预期值A，新的预期值B。当且仅当旧的预期值A和内存值V相同时，将内存值改为B，否则什么也不做。
     * concurrent包都是基于cas来实现的
     *
     * Compare and Swap的缩写，翻译过来就是比较并替换
     */
}
