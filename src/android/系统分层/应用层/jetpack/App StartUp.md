App Startup 设计的初衷，正是为了收拢 ContentProvider。有不少第三方的 SDk，为了使用者不必手动调用 SDK#init 方法，
使用了 ContentProvider 这一个骚操作。

在 AndroidManifest 里面注册了自己的 xxSDkProvider，然后在 xxSDkProvider 的 onCreate 方面里面进行初始化，
确实调用者不需要自己初始化了，可却增加了启动耗时，如果要作优化，还得自己剔除 ContentProvider 的初始化，值不值得，我是感觉没必要。

```
<application ...>

    <provider
        android:name=".xxSDkProvider"
        android:authorities="${applicationId}.xxSDkProvider"
        android:exported="false" />

</application>

class XXSDKProvider : ContentProvider() {

    override fun onCreate(): Boolean {
        Log.d(TAG, "XXSDKProvider create()")
        XXSDK.init()
        return true
    }
    
    .....
}
```
App start up，我觉得他的设计初衷应该是为了收拢 ContentProvider，实际上对启动优化的帮助不是很大。

实际项目中 启动优化，大多数啊都会使用多线程异步加载，这时候 App start up 就显得很鸡肋了，没用