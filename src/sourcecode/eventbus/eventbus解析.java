package sourcecode.eventbus;

public class eventbus解析 {
    /**
     * 注册订阅者总结：
     * (1).首先用register()方法注册一个订阅者
     * (2).获取该订阅者的所有订阅的方法
     * (3).根据该订阅者的所有订阅的事件类型，将订阅者存入到每个以 事件类型为key 以所有订阅者为values的map集合中
     * (4).然后将订阅事件添加到以订阅者为key 以订阅者所有订阅事件为values的map集合中
     */
    /**
     * 注销订阅者总结：
     * (1).首先通过unregister方法拿到要取消的订阅者
     * (2).得到该订阅者的所有订阅事件类型
     * (3).遍历事件类型，根据每个事件类型获取到所有的订阅者集合，并从集合中删除该订阅者
     */
    /**
     * 发送事件总结:
     * (1).首先获取当前线程的事件队列
     * (2).将要发送的事件添加到事件队列中
     * (3).根据发送事件类型获取所有的订阅者
     * (4).根据响应方法的执行模式，在相应线程通过反射执行订阅者的订阅方法
     *
     */
}
