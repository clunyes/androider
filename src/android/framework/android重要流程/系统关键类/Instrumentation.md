工具类
强大的跟踪application及activity生命周期的功能，用于android 应用测试框架中，被做为基类使用。  

查看其提供的方法，比如：callActivityOnCreate,callApplicationOnCreate,
newActivity,callActivityOnNewIntent 等基本上在application和activity的所有生命周期调用中，
都会先调用instrumentation的相应方法。并且针对应用内的所有activity都生效。
为程序员提供了一个强大的能力，有更多的可能性进入android app框架执行流程。