# Eventbus基础概念
#### **EventBus的三要素**
EventBus有三个主要的元素需要我们先了解一下：

* Event：事件，可以是任意类型的对象。
* Subscriber：事件订阅者，在EventBus3.0之前消息处理的方法只能限定于onEvent、onEventMainThread、
onEventBackgroundThread和onEventAsync，他们分别代表四种线程模型。而在EventBus3.0之后，
事件处理的方法可以随便取名，但是需要添加一个注解@Subscribe，并且要指定线程模型（默认为POSTING），四种线程模型下面会讲到。
* Publisher：事件发布者，可以在任意线程任意位置发送事件，直接调用EventBus的post(Object)方法。
可以自己实例化EventBus对象，但一般使用EventBus.getDefault()就好了，根据post函数参数的类型，会自动调用订阅相应类型事件的函数。

#### **EventBus的四种ThreadMode（线程模型）**
EventBus3.0有以下四种ThreadMode：

* POSTING（默认）：如果使用事件处理函数指定了线程模型为POSTING，那么该事件在哪个线程发布出来的，
事件处理函数就会在这个线程中运行，也就是说发布事件和接收事件在同一个线程。
在线程模型为POSTING的事件处理函数中尽量避免执行耗时操作，因为它会阻塞事件的传递，甚至有可能会引起ANR。
* MAIN:
事件的处理会在UI线程中执行。事件处理时间不能太长，长了会ANR的。* BACKGROUND：如果事件是在UI线程中发布出来的，
那么该事件处理函数就会在新的线程中运行，如果事件本来就是子线程中发布出来的，那么该事件处理函数直接在发布事件的线程中执行。
在此事件处理函数中禁止进行UI更新操作。
* MAIN_ORDERED：EventBus3.1.1之后新加入的，和MAIN不同的是一定会排队执行
* ASYNC：无论事件在哪个线程发布，该事件处理函数都会在新建的子线程中执行，同样，此事件处理函数中禁止进行UI更新操作。

