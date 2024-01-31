package android.四大组件.broadcastReceiver;

public class broadcast {
    /**
     * 广播
     * 动态广播是在代码里注册的，静态广播是在AndroidManifest.xml（清单文件）中注册的。
     *
     * 动态广播优先级>静态广播：不管静态广播的优先级设置多高。
     *
     * 动态广播不是常驻广播，也就是应用关闭后，动态广播也会随之关闭，静态广播是常驻广播，应用关闭后也可以收到消息。
     *
     * android8.0之后，静态广播receiver需要配置自定义的 action（事件类型），否则收不到广播
     */
}
