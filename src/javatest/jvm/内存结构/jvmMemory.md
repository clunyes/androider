#### 线程独占区

程序计数器
• 相当于一个执行代码的指示器，用来确认下一行执行的地址
• 每个线程都有一个
• 没有 OOM 的区

java虚拟机栈
• 我们平时说的栈就是这块区域
• java 虚拟机规范中定义了 OutOfMemeory , stackoverflow 异常

如果线程请求的栈深度大于虚拟机所允许的深度，将抛出StackOverflowError异常；
当栈扩展时无法申请到足够的内存会抛出OutOfMemoryError异常。

本地方法栈
• java 虚拟机规范中定义了 OutOfMemory ，stackoverflow 异常
本地方法栈（Native Method Stacks）与虚拟机栈所发挥的作用是非常相似的，其区别只是虚拟机栈为虚拟机执行Java方法（也就是字节码）服务，
而本地方法栈则是为虚拟机使用到的本地（Native）方法服务。
• 在 hotspotVM 中把虚拟机栈和本地方法栈合为了一个栈区



#### 线程共享区
java 堆
• 虚拟机能管理的最大的一块内存 GC 主战场
• 会出现 OOM
• 对象实例
• 数据的内容

```
Java 堆是垃圾收集器管理的主要区域，因此也被称作GC堆（Garbage Collected Heap）.从垃圾回收的角度，
由于现在收集器基本都采用分代垃圾收集算法，所以Java堆还可以细分为：新生代和老年代：
再细致一点有：Eden空间、From Survivor、To Survivor空间等。进一步划分的目的是更好地回收内存，或者更快地分配内存。
```

方法区
• ClassLoader 加载类信息
• 常量、静态变量
• 编译后的代码
• 会出现 OOM
• 运行时常量池
    • public static final
    • 符号引用类、接口全名、方法名
```
方法区是一个规范，它的实现取决于不同的虚拟机。
在Java8之前，HotSpot虚拟机使用永久代来实现方法区。
而Java8之后，HotSpot虚拟机使用元空间来实现方法区。
```


执行引擎机制：
• 解释器：将字节码逐行解释执行。
• JIT编译器(即时编译器)：将字节码整体编译为机器码执行。