package design_pattern.structural_design_pattern.facade;
//要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。外观模式提供一个高层次的接口，使得子系统更易于使用。

/**
 * 在android中，context就是外观模式，基本的操作可以通过context来操作
 *
 * 外观模式在Android中应用也非常广泛，比如Context类，里面封装了很多方法，还是以startActivity()方法为例。
 * 实际上startActivity()是通过ActivityManagerService来实现的，ActivityManagerService我们应该都有耳闻，
 * 但是实际开发中一般都用不到，通过封装的方式，Context类隐藏了这些细节，我们只要简单调个方法就可以启动一个新的Activity。
 * 这就是外观模式在Android应用的例子了。当然这种应用比比皆是，我们平时开发也经常用的到。
 *
 */