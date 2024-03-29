# rxjava概述
#### ReactiveX与RxJava
在讲到RxJava之前我们首先要了解什么是ReactiveX，因为RxJava是ReactiveX的一种java实现。
ReactiveX是Reactive Extensions的缩写，一般简写为Rx，微软给的定义是，Rx是一个函数库，
让开发者可以利用可观察序列和LINQ风格查询操作符来编写异步和基于事件的程序，开发者可以用Observables表示异步数据流，
用LINQ操作符查询异步数据流， 用Schedulers参数化异步数据流的并发处理，Rx可以这样定义：Rx = Observables + LINQ + Schedulers。

#### 为何要用RxJava
想到异步的操作我们会想到android的AsyncTask 和Handler，但是随着请求的数量越来越多，
代码逻辑将会变得越来越复杂而RxJava却仍旧能保持清晰的逻辑。RxJava的原理就是创建一个Observable对象来干活，
然后使用各种操作符建立起来的链式操作，就如同流水线一样把你想要处理的数据一步一步地加工成你想要的成品然后发射给Subscriber。

#### RxJava与观察者模式
RxJava的异步操作是通过扩展的观察者模式来实现的，不了解观察者模式的可以先看下 设计模式（五）
观察者模式这篇文章Rxjava有四个基本的要素：Observable (被观察者)、 Observer (观察者)、 subscribe (订阅)、event(事件)。
Observable (被观察者) 和 Observer (观察者)通过 subscribe() 方法实现订阅关系，Observable就可以在需要的时候来通知Observer。



#### 背压Backpressure
在RxJava的使用中，由于RxJava的架构是观察者模式，
被观察者Observable和观察者Observer的产生事件和处理事件的速度可能会有所差异，这样也许就会导致程序崩溃。

举个例子，你在看电视剧，你看电视剧的速度很快，但是电视剧更新的速度很慢，那你等电视剧更新了再看，这样其实是可以的。
但是如果电视剧更新的速度很快，而你看电视剧的速度很慢，这样电视剧一集一集的就会累加起来，到最后，你就会积累了一堆没看的电视剧，
你积压了电视剧也许不会崩溃，但是如果程序堆积了很多事件，最终就会挤爆内存，导致程序崩溃。

那怎么办呢？可以解决这种问题吗？

在上面的例子里面可以看见，电视剧(被观察者)是主动的推送数据给我们(观察者)，我们是被动接收的。

所以背压其实就是在异步中，被观察者发送事件速度远快于观察者的处理速度的情况下，可以采取的一种控制流速的策略，
就是告诉上游的被被观察者降低发送速度。

响应式拉取就是一种背压策略，可以让观察者可以根据自身实际情况去被观察者那里拉取数据，
而不是被动接收被观察者发送的数据，就是告诉被观察者，慢一点慢一点，我电视剧看不完啦！
可以让被观察者变成被动式，等待观察者的通知再发送数据。这样就实现了控制上游被观察者发送事件的速度，这就是背压，一种策略。



