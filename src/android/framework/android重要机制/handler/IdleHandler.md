IdleHandler 就是 Handler 机制提供的一种，可以在 Looper 事件循环的过程中，当出现空闲的时候，允许我们执行任务的一种机制。

IdleHandler 被定义在 MessageQueue 中，它是一个接口。

```java
// MessageQueue.java
public static interface IdleHandler {
    boolean queueIdle();
}
```
可以看到，定义时需要实现其 queueIdle() 方法。同时返回值为 true 表示是一个持久的 IdleHandler 会重复使用，
返回 false 表示是一个一次性的 IdleHandler。

准备执行 IdleHandler 时，说明当前待执行的消息为 null，或者这条消息的执行时间未到；