在JDK1.7 中，由“数组+链表”组成，数组是 HashMap 的主体，链表则是主要为了解决哈希冲突而存在的。

在JDK1.8 中，由“数组+链表+红黑树”组成。当链表过长，则会严重影响 HashMap 的性能，
红黑树搜索时间复杂度是 O(logn)，而链表是糟糕的 O(n)。



HashMap的主干是一个Entry数组。Entry是HashMap的基本组成单元，每一个Entry包含一个key-value键值对，hash值，下一个entry节点（构成单向链表）。
HashMap采用Entry数组来存储key-value对，每一个键值对组成了一个Entry实体，Entry类实际上是一个单向的链表结构，它具有Next指针，
可以连接下一个Entry实体，依次来解决Hash冲突的问题，因为HashMap是按照Key的hash值来计算Entry在HashMap中存储的位置的，
如果hash值相同，而key内容不相等，那么就用链表来解决这种hash冲突。


根据代码i去数组上找，如果有相同entry，替换，没有，加入链表


红黑树是JDK8中对hashmap作的一个变更，在JDK7之前，HashMap采用数组+链表的形式存储数据，我们知道优秀的hash算法应避免碰撞的发生,
但假如开发者使用了不合适的hash算法，O(1)级别的数组查询会退化到O(n)级链表查询，因此在JDK8中引入红黑树的，当一个结点的链表长度大于8时，
链表会转换成红黑树，提高查询效率,而链表长度小于6时又会退化成链表