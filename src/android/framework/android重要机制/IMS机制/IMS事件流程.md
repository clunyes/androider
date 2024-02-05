IMS 是SystemServer startOtherService拉起
其中EventHub逻辑已经合入InputReader内部

逻辑关键类，路径/frameworks/native/services/inputflinger/，单独有文件目录reader dispatcher
下面两个类在InputManager构造函数中，初始化

#### InputReader
通过EventHub获取原始事件，并对原始事件进行封装，回调InputDispatcher的notifyKey

### InputDispatcher
notifyKey调用后，重新装包，唤醒当前线程，分发事件到合适窗口
分发过程NotifyMotionArgs为例，检查事件是否有效，进行过滤，构建MotionEntry进队列，唤醒线程分发
（有三种不同事件NotifyKeyArgs，NotifyMotionArgs，NotifySwitchArgs）
分发过程：事件进行加工，过滤，调用findTouchedWindowTargetsLocked寻找合适窗口，发送事件