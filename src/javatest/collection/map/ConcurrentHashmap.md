hashtable：方法上加锁，性能不好
ConcurrentHashMap：实现线程安全的思想也已经完全变了，它摒弃了Segment（锁段）的概念，
而是启用了一种全新的方式实现,利用CAS算法。它沿用了与它同时期的HashMap版本的思想，
底层依然由“数组”+链表+红黑树的方式思想，但是为了做到并发，又增加了很多辅助的类，例如TreeBin，Traverser等对象内部类。