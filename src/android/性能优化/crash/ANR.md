ANR——应用无响应，Activity是5秒，BroadCastReceiver是10秒，Service是20秒。
关键日志是timeout

1. KeyDispatchTimeout（常见）
input事件在5S内没有处理完成发生了ANR。
logcat日志关键字：Input event dispatching timed out

2. BroadcastTimeout
前台Broadcast：onReceiver在10S内没有处理完成发生ANR。
后台Broadcast：onReceiver在60s内没有处理完成发生ANR。
logcat日志关键字：Timeout of broadcast BroadcastRecord

3. ServiceTimeout
前台Service：onCreate，onStart，onBind等生命周期在20s内没有处理完成发生ANR。
后台Service：onCreate，onStart，onBind等生命周期在200s内没有处理完成发生ANR
logcat日志关键字：Timeout executing service

4. ContentProviderTimeout
ContentProvider 在10S内没有处理完成发生ANR。 logcat日志关键字：timeout publishing content providers