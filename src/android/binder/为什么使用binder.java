package android.binder;

public class 为什么使用binder {
    /**
     * 管道/消息队列/共享内存/信号量/Socket ？？
     *
     * 为啥选择binder
     * binder：1.cs架构，CS相互独立 2.效率比较高（只要一次拷贝，使用内存映射技术），共享内存不拷贝实现方式复杂
     * 3.安全性  验证UID/PID(用户ID/进程ID)
     */
}
