1. implicit intent 的限制
如果应用尝试使用隐式 intent 启动该 activity，则会抛出异常
```
// Throws an exception when targeting Android 14.
context.startActivity(Intent("com.example.action.APP_ACTION"))
```
要启动未导出的 Activity，应用应改用显式 Intent：
```
val explicitIntent =
       Intent("com.example.action.APP_ACTION")
explicitIntent.apply {
   package = context.packageName
}
context.startActivity(explicitIntent)
```

2. 运行时注册的广播接收器，必须设置是否export，是否允许其他进程调用