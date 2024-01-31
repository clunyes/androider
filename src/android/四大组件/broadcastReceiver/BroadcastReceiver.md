静态广播：manifest注册
在AndroidManifest.xml中注册的BroadcastReceiver, 每次收到一个Intent, 也就是onReceive被回调的时候,
这个BroadcastReceiver都是新创建出来的。出了onReceive, 这个BroadcastReceiver对象的生命周期就已经到头了, 
这也是为什么我们不能在onReceive中进行一些异步操作的原因, 有可能异步操作还没完成, BroadcastReceiver所在的进程就被kill了。

动态广播：代码中注册
动态广播的优先级比静态广播高

android8.0以上无法收到静态注册的隐式广播
方法一：发送广播时改为显式广播:intent.setPackage(getPackageName())
方法二：添加可后台执行的flag: intent.addFlags(0x01000000)


无序广播
1. 普通广播
2. 系统广播
3. 本地广播（本地广播可理解为一种局部广播，广播的发送者和接收者都同属于一个App。相比于全局广播（普通广播），
App应用内广播优势体现在：安全性高 & 效率高）LocalBroadcastManager

有序广播
1. 广播接受者接收广播的顺序规则（同时面向静态和动态注册的广播接受者）
   按照Priority属性值从大-小排序；
   Priority属性相同者，动态注册的广播优先；
   Context.sendOrderedBroadcast()