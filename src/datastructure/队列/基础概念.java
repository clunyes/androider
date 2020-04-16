package datastructure.队列;

public class 基础概念 {
    /**
     * 先进者先出，就是"队列" 我们可以想象成，排队买票，先来的先买，后来的只能在末尾，不允许插队。
     *
     * 队列的两个基本操作：入队 将一个数据放到队列尾部；出队 从队列的头部取出一个元素。
     * 队列也是一种操作受限的线性表数据结构 它具有先进先出的特性，支持队尾插入元素，在队头删除元素。
     *
     * 队列的概念很好理解，队列的应用也非常广泛如：循环队列、阻塞队列、并发队列、优先级队列等。
     *
     */
    /**
     *  add()  remove()           是有边界的，
     *
     *          *      add              超出之后会报 "java.lang.IllegalStateException: Queue full" 异常
     *
     *          *      remove         超出之后会报 "java.util.NoSuchElementException" 异常
     *
     *  offer()  poll()                 没有边界，会返回 boolean, peek():当前队列的第一个值，不会删除数据
     *
     *          *      true
     *
     *          *      false
     *
     * put()  take()                   阻塞 ，满了一直等，取不出来也一直等
     */
}
