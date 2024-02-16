# Subject
说到Subject，很多人可能都不是很熟悉它，因为相对于RxJava的Observable、Schedulers、Subscribes等关键字来讲，
它抛头露面的场合似乎很少。



事实上，Subject作用是很大的，借用官方的解释，Subject在同一时间内，既可以作为Observable，也可以作为Observer:

Processor：Subject和Processor的功能几乎是一样的，区别在于Subject不支持背压，而Processor支持背压。



Subject和Processor的功能几乎是一样的，区别在于Subject不支持背压，而Processor支持背压。



在RxJava3.x中，官方一共为我们提供了以下四种常用Subject（进阶之光书中提到了8个。。。）：



* ReplaySubject： 无论subscribe订阅是何时开始的，Observer会接收ReplaySubject发送的所有事件。
* BehaviorSubject：Observer会先接收BehaviorSubject被订阅之前的最后一个事件，然后接收订阅之后送的所有事件。
* PublishSubject：Observer只接收PublishSubject被订阅之后发送的事件。
* AsyncSubject：无论订阅发生在什么时候，Observer只会接收AsyncSubject发送的在onComplete()之前的最后一个数据，
且onComplete()是必须要调用的。



