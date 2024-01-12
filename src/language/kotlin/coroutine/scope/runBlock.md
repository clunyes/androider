runBlocking 的一个方便之处就是：只有当内部相同作用域的所有协程都运行结束后，声明在 runBlocking 之后的代码才能执行，
即 runBlocking 会阻塞其所在线程.


runBlocking 本身带有阻塞线程的意味，但其内部运行的协程又是非阻塞的，读者需要明白这两者的区别.