package android;

public class activity启动流程 {
    /**
     * 纵观整个流程可以看出，启动过程经过多次调用涉及到了不少类并且整个流程也甚是复杂繁琐，所以我们有必要在分析完流程后总结一下，这可以帮我们从宏观上对整体流程认识更加深刻。
     *
     * 首先我们来回顾下整个流程涉及的类以及其作用：
     *
     *     Instrumentation：每一个应用程序只有一个Instrumentation对象，每个Activity内都有一个对该对象的引用。Instrumentation可以理解为应用进程的管家，ActivityThread要创建或暂停某个Activity时，都需要通过Instrumentation来进行具体的操作。
     *
     *     ActivityManagerService： Android中最核心的服务之一，主要负责系统中四大组件的启动、切换、调度及应用程序的管理和调度等工作
     *
     *     ActivityManager：该类提供与Activity、Service和Process相关的信息以及交互方法， 可以被看作是ActivityManagerService的辅助类
     *
     *     ActivityThread：App的真正入口，当App启动后，会调用其main方法开始执行，开启消息循环队列。是传说中的UI线程，即主线程。与ActivityManagerService配合，一起完成Activity的管理工作；
     *
     *     ApplicationThread：用来实现ActivityManagerService与ActivityThread之间的交互。在ActivityManagerService需要管理相关Application中的Activity的生命周期，通过ApplicationThread的代理对象与ActivityThread通讯；
     *
     *     ActvitityStack：Activity在AMS的栈管理，用来记录已经启动的Activity的先后关系、状态信息等。通过ActivityStack决定是否需要启动新的进程；
     *
     *     ActivityRecord：ActivityStatck的管理对象，每个Activity在AMS对应的一个ActivityRecord，来记录Activity的状态以及其他信息。可以理解为Activity在服务端的Activity对象的映射；
     *
     *     TaskRecord：AMS抽象出来的任务栈的概念。一个TaskRecord包含若干个ActivityRecord。ASM用它来确保Activity启动和退出顺序。它与Activity的启动模式直接相关。
     *
     *     ActivityStarter：启动Activity的控制器，主要用于用来将Intent和flags转换成activity和相关任务栈；
     *
     *     ActivityStackSupervisor：负责所有Activity栈的管理。内部管理了mHomeStack、mFocusedStack和mLastFocusedStack三个Activity栈。其中，mHomeStack管理的是Launcher相关的Activity栈；mFocusedStack管理的是当前显示在前台Activity的Activity栈；mLastFocusedStack管理的是上一次显示在前台Activity的Activity栈。
     *
     * 对于以上类我们要熟悉其作用。
     *
     * 接下来就是启动流程的总结了：（此处以 A启动B为例）
     * 1、Activity A通过startActivity等函数启动B
     * 2、步骤1调用之后当前应用会向AMS发送一个启动Activity B的进程间通信请求；
     * 3、AMS会将要启动的Activity B的组件信息保存下来，ActivityManagerService接收到启动请求后会进行必要的初始化以及状态的刷新，然后解析Activity的启动模式，为启动Activity做一系列的准备工作。
     *
     * 4、然后判断栈顶是否为空，如果不为空即当前有Activity A显示在前台，则会先进行栈顶Activity的onPause流程，此过程是通过Binder通信（ApplicationThread及其接口定义语言）完成
     * 5、Activity A完成pause操作后，通过Binder通信（ActivityManagerService及其接口定义语言）通知AMS，可以执行启动Activity B的操作了（要启动的activity信息保存在了栈顶）（此处需要注意的是如果Activity被启动过则直接执行onRestart->onStart->onResume过程直接启动Activity（热启动过程）。否则执行Activity所在应用的冷启动过程。冷启动的过程是通过Zygote进程fork出一个新的进程然后执行ActivityThread的main方法启动新进程）
     * 6、上述步骤完成后AMS执行一系列启动Activity B的操作，并通过Binder通信（ApplicationThread及其接口定义语言）进行跨进程调用，将Activity B启动起来；
     */

    /**
     * 面试术语
     *
     * Activity的启动过程，我们可以从Context的startActivity说起，其实现是ContextImpl的startActivity，
     * 然后内部会通过Instrumentation来尝试启动Activity，这是一个跨进程过程，它会调用ams的startActivity方法，
     * 当ams校验完activity的合法性后，会通过ApplicationThread回调到我们的进程，这也是一次跨进程过程，
     * 而applicationThread就是一个binder，回调逻辑是在binder线程池中完成的，所以需要通过Handler H将其切换到ui线程，
     * 第一个消息是LAUNCH_ACTIVITY，它对应handleLaunchActivity，在这个方法里完成了Activity的创建和启动，
     * 接着，在activity的onResume中，activity的内容将开始渲染到window上，然后开始绘制直到我们看见。——任玉刚大佬
     */

    //https://blog.csdn.net/u010648159/article/details/81103092

    /**
     * stub android.binder.binder
     */
}
