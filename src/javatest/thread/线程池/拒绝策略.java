package javatest.thread.线程池;

public class 拒绝策略 {
    /**
     * 拒绝策略说明
     *
     * AbortPolicy为java线程池默认的阻塞策略，不执行此任务，而且直接抛出一个运行时异常。
     * DiscardPolicy也是丢弃任务，但是不抛出异常
     * DiscardOldestPolicy丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     * CallerRunsPolicy由调度线程处理该任务
     *
     */
}
