package android.四大组件.service;

public class service启动方式 {
    /**
     *  1、startService 启动的服务：主要用于启动一个服务执行后台任务，不进行通信
     *  生命周期如下：
     *  onCreate（）-->onStartCommand()-->onDestroy()
     *  如果该服务已经开启，不在执行onCreate(),而是会调用onStart()和onStartCommand().。停止服务的时候调用onDestroy(),服务会只被停止一次。
     *  特点：一旦服务开启跟调用者(开启者)就没有任何关系了。开启者退出了，服务还在后台长期的运行。开启者不能调用服务里面的方法。
     *
     *  2、bindService 启动的服务：该方法启动的服务可以进行通信。停止服务使用unbindService；
     *  生命周期如下：
     *
     * onCreate() --->onBind()--->onunbind()--->onDestory()
     *
     * 绑定服务不会调用onstart()或者onstartcommand()方法
     * 特点：bind的方式开启服务，绑定服务，调用者挂了，服务也会跟着挂掉。绑定者可以调用服务里面的方法。
     */
}
