package android.四大组件.activity;

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
     * 5、Activity A完成pause操作后，通过Binder通信（ActivityManagerService及其接口定义语言）通知AMS，可以执行启动Activity B的操作了（要启动的activity信息保存在了栈顶）
     * （此处需要注意的是如果Activity被启动过则直接执行onRestart->onStart->onResume过程直接启动Activity（热启动过程）。否则执行Activity所在应用的冷启动过程。冷启动的过程是通过Zygote进程fork出一个新的进程然后执行ActivityThread的main方法启动新进程）
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
     * 我们以点击Launcher的一个icon为开始，整体扯一下Activity的启动过程，桌面其实就是LauncherApp的一个Activity
     *
     * 1. 当点击Launcher的icon开始，Launcher进程会像AMS发送点击icon的启动信息
     * （这些信息就是在AndroidMainifest.xml中标签定义的启动信息，数据由PackageManagerService解析出来）
     *
     * 2. AMS收到信息后会先后经过ActivityTaskManagerService->ActivityStartController->ActivityStarter内部类Request，
     * 然后把信息存到Request中，并通知Launcher进程让Activity休眠
     * （补充个小知识点，这个过程会检测Activity在AndroidMainifest.xml的注册，如果没有注册就报错了）
     *
     *
     * 3. Launcher进程的ApplicationThread对象收到消息后调用handlePauseActivity()进行暂停，并通知AMS已经暂停。
     * 实现细节：ActivityThread.sendMessage()通过ActivityThread的H类发送Handler消息，然后触发 mTransactionExecutor.execute(transaction)，
     * 执行过程中依赖ActivityClientRecord.mLifecycleState数值并通过ClientTransactionHandler抽象类的实现（ActivityThread）进行分发。
     * 注 ：ActivityClientRecord.mLifecycleState（-1 ~ 7分别代表  UNDEFINED,           PRE_ON_CREATE,           ON_CREATE,           ON_START,           ON_RESUME,           ON_PAUSE,           ON_STOP,           ON_DESTROY,           ON_RESTART）
     *
     * 4. AMS收到Launcher的已暂停消息后，会检查要启动的Activity所在的进程是否已经启动了，
     * 如果已经启动了就打开，如果未启动则通过Process.start(android.app.ActivityThread)来启动一个新的进程。
     *
     *
     * 5. 进程创建好以后，会调用ActivityThread.main(),初始化MainLooper，并创建Application对象。
     * 然后Instrumentation.newApplication()反射创建Application，创建ContextImpl通过Application的attach方法与Application进行绑定，
     * 最终会调用Instrumentation.callApplicationOnCreate执行Application的onCreate函数进行一些初始化的工作。完成后会通知AMS进程已经启动好了。
     * 通知过程：通过IActivityManager.attachApplication（IApplicationThread thread, long startSeq），将Application对象传入AMS
     *
     *
     * 6. AMS收到app进程启动成功的消息后，从ActivityTaskManagerService中取出对应的Activity启动信息，
     * 并通过ApplicationThreadProxy对象，调用其scheduleTransaction(ClientTransaction transaction)方法，
     * 具体要启动的Activity都在ClientTransaction对象中。
     *
     * 7. app进程的ApplicationThread收到消息后会调用ActiivtyThread.sendMessage()，通过H发送Handler消息，
     * 在handleMessage方法的内部又会调用 mTransactionExecutor.execute(transaction);具体参考第3步
     * 最终调用performLaunchActivity方法创建activity和context并将其做关联，
     * 然后通过mInstrumentation.callActivityOnCreate()->Activity.performCreate()->Activity.onCreate()回调到了Activity的生命周期。
     *
     */

    /**
     * stub android.framework.android重要机制.binder机制.binder
     */
}
