我们应该要知道，在创建一个对象的时候，JAVA会用到内存里面的3个东西，
堆：存放所用new出来的对象
栈：存放对象的引用（也就是地址），基本数据类型产生的变量
常量池：（常量池也在方法去）是用来存放String常量，如“abc”

1. 每次创建对象时，都需要进行加载和创建2个操作：
1.1 先去判断需要的类是否已经加载，如果已经加载了，则无需再加载，如果没有加载，则需要通过类加载器加载类信息到方法区
1.2 在堆中创建新对象
2. 栈、堆、方法区的存储
栈：对象的引用、局部变量
堆：对象和全局变量（属性）
方法区：类信息、属性信息、方法信息
3. 方法的调用机制
每次调用方法，伴随着“方法入栈”操作，也就是栈中为该方法分配了一块空间，用于保存该方法中涉及到的变量
每次方法调用结束，伴随着“方法出栈”操作，也就是栈中分配的空间被释放了
在类的方法调用过程中，首先判断方法区是否存在该方法，存在则方法入栈，调用结束后出栈。