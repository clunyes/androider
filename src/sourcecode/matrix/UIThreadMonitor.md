UIThreadMonitor: 一个监听 UI 线程的监视器，它实现了 Runnable 所以是一个线程。
两个核心

1. Choreographer 可以简单理解为帧率监听器；
接收 VSync 信号监听每帧回调，使用反射获取帧率数据
2. LooperMonitor Looper 监听。
仍然通过反射，获取looper中的printer，做封装，通过setMessageLogging设置新的printer，达到监听主线程每条消息处理前后的信息
```
    if (logging != null) {
         logging.println(">>>>> Dispatching to " + msg.target + " " +
               msg.callback + ": " + msg.what);
   }

   if (logging != null) {
         logging.println("<<<<< Finished to " + msg.target + " " + msg.callback);
   }
```
