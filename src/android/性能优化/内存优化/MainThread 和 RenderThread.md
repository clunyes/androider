# MainThread 和 RenderThread
##### 主线程
Android App 的进程是基于 Linux 的，其管理也是基于 Linux 的进程管理机制，所以其创建也是调用了 fork 函数

frameworks/base/core/jni/com_android_internal_os_Zygote.cpp

pid_t pid = fork();

Fork 出来的进程，我们这里可以把他看做主线程，但是这个线程还没有和 Android 进行连接，
所以无法处理 Android App 的 Message ；由于 Android App 线程运行基于消息机制 ，
那么这个 Fork 出来的主线程需要和 Android 的 Message 消息绑定，才能处理 Android App 的各种 Message。

##### 渲染线程
渲染线程也就是 RenderThread ，最初的 Android 版本里面是没有渲染线程的，
渲染工作都是在主线程完成，使用的也都是 CPU ，调用的是 libSkia 这个库，
RenderThread 是在 Android Lollipop 中新加入的组件，负责承担一部分之前主线程的渲染工作，减轻主线程的负担。

我们一般提到的硬件加速，指的就是 GPU 加速，这里可以理解为用 RenderThread 调用 GPU 来进行渲染加速 。
硬件加速在目前的 Android 中是默认开启的， 所以如果我们什么都不设置，
那么我们的进程默认都会有主线程和渲染线程(有可见的内容)。
我们如果在 App 的 AndroidManifest 里面，在 Application 标签里面加一个
```
android:hardwareAccelerated="false"
```
我们就可以关闭硬件加速。