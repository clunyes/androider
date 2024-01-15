package android.applaunch;

public class App启动流程 {
    /**
     *
     *1.
     * app 冷启动是说从桌面启动 app ，此时我们的应用是没有进程的，需要创建。Activity 启动 Activity，指的是进程内启动新的页面，此时应用进程是存在的。系统桌面也是一个 Activity ，
     * 名叫 Launch ，所以 app 冷启动和 Activity 启动 Activity 差不多，走的都是 Activity 内部的方法，区别就是先启动应用进程的事，这样说大家就对这两种启动 Activity 的情况心里有数了
     *
     * 这块必须清楚，因为面试时很多时候会问的，有的面试官会问你2者的关联，区别，简单的自会问你 Activity 启动流程，你把2种 Activity 启动方式的关联一说，绝对涨分。
     * 除了面试环节外，我们也能熟悉下系统流程，后面插件化会用到，另外也会对我们自己封装框架，学习系统其他深入知识点有很大的帮助，比如 AIDL 双向通讯，功能分割，代理分层，有助于我们以后看各种框架
     *
     * app 的启动流程简单来说：
     *
     *     用户点击 icon
     *     系统开始加载和启动应用
     *     应用启动：开启空白(黑色)窗口
     *     创建应用进程
     *     初始化Application
     *     启动 UI 线程
     *     创建第一个 Activity
     *     解析(Inflater)和加载内容视图
     *     布局(Layout)
     *     绘制(Draw)
     *
     */

    /**
     * 三个进程：
     *
     * Launcher进程：整个App启动流程的起点，负责接收用户点击屏幕事件，它其实就是一个Activity，里面实现了点击事件，长按事件，触摸等事件，
     * 可以这么理解，把Launcher想象成一个总的Activity，屏幕上各种App的Icon就是这个Activity的button，当点击Icon时，会从Launcher跳转到其他页面。
     *
     * SystemServer进程：这个进程在整个的Android进程中是非常重要的一个，地位和Zygote等同，它是属于Application Framework层的，
     * Android中的所有服务，例如AMS, WindowsManager, PackageManagerService等等都是由这个SystemServer fork出来的。
     *
     * App进程：你要启动的App所运行的进程。
     *
     *
     * 六个大类：
     *
     * ActivityManagerService：（AMS）AMS是Android中最核心的服务之一，主要负责系统中四大组件的启动、切换、调度及应用进程的管理和调度等工作，
     * 其职责与操作系统中的进程管理和调度模块相类似，因此它在Android中非常重要，它本身也是一个Binder的实现类。
     *
     * Instrumentation：监控应用程序和系统的交互。
     *
     * ActivityThread：应用的入口类，通过调用main方法，开启消息循环队列。ActivityThread所在的线程被称为主线程。
     *
     * ApplicationThread：ApplicationThread提供Binder通讯接口，AMS则通过代理调用此App进程的本地方法。
     *
     * ActivityManagerProxy：AMS服务在当前进程的代理类，负责与AMS通信。
     *
     * ApplicationThreadProxy：ApplicationThread在AMS服务中的代理类，负责与ApplicationThread通信。
     */


    /**
     *
     * App 启动过程
     *
     * 这里以启动微信为例子说明
     *
     *     Launcher通知AMS 要启动微信了，并且告诉AMS要启动的是哪个页面也就是首页是哪个页面
     *     AMS收到消息告诉Launcher知道了，并且把要启动的页面记下来
     *     Launcher进入Paused状态，告诉AMS，你去找微信吧
     *
     * 上述就是Launcher和AMS的交互过程
     *
     *     AMS检查微信是否已经启动了也就是是否在后台运行，如果是在后台运行就直接启动，如果不是，AMS会在新的进程中创建一个ActivityThread对象，并启动其中的main函数。
     *     微信启动后告诉AMS，启动好了
     *     AMS通过之前的记录找出微信的首页，告诉微信应该启动哪个页面
     *     微信按照AMS通知的页面去启动就启动成功了。
     *
     */
    /**
     * Activity 启动过程
     *
     * Activity 启动过程是由 ActivityMangerService（amS) 来启动的，底层 原理是 Binder实现的 最终交给 ActivityThread 的 performActivity 方法来启动她
     *
     * ActivityThread大概可以分为以下五个步骤
     *
     *     通过ActivityClientRecoed对象获取Activity的组件信息
     *     通过Instrument的newActivity使用类加载器创建Activity对象
     *     检验Application是否存在，不存在的话，创建一个，保证 只有一个Application
     *     通过ContextImpl和Activity的attach方法来完成一些初始化操作
     *     调用oncreat方法
     *
     * 想详细了解的可以参考这一篇文章，个人觉得写得还不错。https://www.jianshu.com/p/13b07beacb1f
     *
     */

}
