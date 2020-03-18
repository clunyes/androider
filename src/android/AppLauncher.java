package android;

public class AppLauncher {
    /**
     * app 冷启动是说从桌面启动 app ，此时我们的应用是没有进程的，需要创建。Activity 启动 Activity，指的是进程内启动新的页面，此时应用进程是存在的。系统桌面也是一个 Activity ，名叫 Launch ，所以 app 冷启动和 Activity 启动 Activity 差不多，走的都是 Activity 内部的方法，区别就是先启动应用进程的事，这样说大家就对这两种启动 Activity 的情况心里有数了
     *
     * 这块必须清楚，因为面试时很多时候会问的，有的面试官会问你2者的关联，区别，简单的自会问你 Activity 启动流程，你把2种 Activity 启动方式的关联一说，绝对涨分。除了面试环节外，我们也能熟悉下系统流程，后面插件化会用到，另外也会对我们自己封装框架，学习系统其他深入知识点有很大的帮助，比如 AIDL 双向通讯，功能分割，代理分层，有助于我们以后看各种框架
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
     *
     * 暂时参考文章
     * https://www.jianshu.com/p/4a8f44b6eecb
     *
     * https://blog.csdn.net/pgg_cold/article/details/79491791
     */
}
