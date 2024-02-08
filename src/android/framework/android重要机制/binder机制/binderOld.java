package android.framework.android重要机制.binder机制;

/**
 * todo 旧的binder整理，根据理解，可以合并
 */
public class binderOld {
    /**
     * 参考文章
     * 原理：https://wangkuiwu.github.io/2014/09/01/Binder-Introduce/
     * demo示例：https://zhuanlan.zhihu.com/p/61344235
     */

    /**
     *
     *
     * ServiceManager存在的原因和意义
     *
     * 要将MediaPlayerService等服务添加到ServiceManager中进行管理时，ServiceManager是服务器，它会收到MediaPlayerService进程的添加服务请求。
     * 当MediaPlayer等客户端要获取MediaPlayerService等服务时，它会向ServiceManager发起获取服务请求。
     *
     * 当MediaPlayer和MediaPlayerService通信时，MediaPlayerService是服务端；而当MediaPlayerService则ServiceManager通信时，ServiceManager则是服务端。
     * 这样，就造就了ServiceManager的特殊性。于是，在Binder驱动中，将句柄0指定为ServiceManager对应的句柄，通过这个特殊的句柄就能获取ServiceManager对象。这部分的知识后面会详细介绍。
     *
     *
     */

    /**
     * 1. binder实体：是各个Server以及ServiceManager在内核中的存在形式。简言之，Binder实体是Server在Binder驱动中的存在形式，内核通过Binder实体可以找到用户空间的Server对象。
     * 2. binder引用：每一个Binder引用都是某一个Binder实体的引用，通过Binder引用可以在内核中找到它对应的Binder实体。
     * 如果将Server看作是Binder实体的话，那么Client就好比Binder引用。Client要和Server通信，它就是通过保存一个Server对象的Binder引用，再通过该Binder引用在内核中找到对应的Binder实体，进而找到Server对象，然后将通信内容发送给Server对象。
     *
     * Binder实体和Binder引用都是内核(即，Binder驱动)中的数据结构。每一个Server在内核中就表现为一个Binder实体，而每一个Client则表现为一个Binder引用。这样，每个Binder引用都对应一个Binder实体，而每个Binder实体则可以多个Binder引用。
     *
     * 3. 远程服务：Server都是以服务的形式注册到ServiceManager中进行管理的。如果将Server本身看作是"本地服务"的话，那么Client中的"远程服务"就是本地服务的代理。如果你对代理模式比较熟悉的话，
     * 就很容易理解了，远程服务就是本地服务的一个代理，通过该远程服务Client就能和Server进行通信。
     */

    /**
     * 典型案例
     * 1. ServiceManager守护进程
     * 2. server注册到serviceManager中
     *
     * Server首先会向Binder驱动发起注册请求，而Binder驱动在收到该请求之后就将该请求转发给ServiceManager进程。但是Binder驱动怎么才能知道该请求是要转发给ServiceManager的呢？
     * 这是因为Server在发送请求的时候，会告诉Binder驱动这个请求是交给0号Binder引用对应的进程来进行处理的。而Binder驱动中指定了0号引用是与ServiceManager对应的。
     * 在Binder驱动转发该请求之前，它其实还做了两件很重要的事：(01) 当它知道该请求是由一个Server发送的时候，它会新建该Server对应的Binder实体。
     * (02) 它在ServiceManager的"保存Binder引用的红黑树"中查找是否存在该Server的Binder引用；找不到的话，就新建该Server对应的Binder引用，并将其添加到"ServiceManager的保存Binder引用的红黑树"中。
     * 简言之，Binder驱动会创建Server对应的Binder实体，并在ServiceManager的红黑树中添加该Binder实体的Binder引用。
     * 当ServiceManager收到Binder驱动转发的注册请求之后，它就将该Server的相关信息注册到"Binder引用组成的单链表"中。这里所说的Server相关信息主要包括两部分：Server对应的服务名 + Server对应的Binder实体的一个Binder引用。
     *
     *
     * 3. client获取远程服务
     */

    /**
     * ContentProvider : 它的底层实现同样是Binder，但是它的使用过程比AIDL方便得多，因为系统为我们做了封装，使得我们不需要关心底层细节就可以轻松实现进程间通信。
     */

    /**
     *
     * ? 代理模式(stub对象？，用例子说明)
     * ？守护进程
     * 守护进程就是通常讲Daemon进程，是linux后台执行的一种服务进程，特点是独立于控制终端、周期性地执行某种任务或等待处理某些发生事件，
     * 不会随终端关闭而停止，直到接受停止信息才会结束。
     *
     *
     */
    /**
     * 怎么实际使用aidl实现进程间通信
     *
     * https://www.cnblogs.com/tangZH/p/10775848.html
     *
     * 如果客户端和服务端在同一个进程下，那么asInterface()将返回Stub对象本身，否则返回Stub.Proxy对象。
     */
}
