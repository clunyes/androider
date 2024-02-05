
```
上一节在AMS启动过程中，我们知道了AMS启动完成前，
在systemReady()中会去调用startHomeOnAllDisplays()来启动Launcher，
本次就从startHomeOnAllDisplays()函数入口，来看看Launcher是如何被启动起来的。

public void systemReady(final Runnable goingCallback, TimingsTraceLog 
traceLog) {
    ...
    //启动Home Activity
    mAtmInternal.startHomeOnAllDisplays(currentUserId, "systemReady");
    ...
}
```

```
getHomeIntent()
构建一个category为CATEGORY_HOME的Intent，表明是Home Activity。
    Intent.CATEGORY_HOME = "android.intent.category.HOME"
这个category会在Launcher3的 AndroidManifest.xml中配置，表明是Home Acivity

```

![img.png](launcher启动图.png)


Launcher的启动由三部分启动：
1) SystemServer完成启动Launcher Activity的调用
2) Zygote()进行Launcher进程的Fork操作
3) 进程启动完成后，进入ActivityThread的main()，继续通过binder调用AMS功能，完成最终Launcher的onCreate操作
