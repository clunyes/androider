package javatest.异常;

public class 区别 {
    /**
     *
     * 1. 运行时异常是不需要捕获的，程序员可以不去处理，当异常出现时，虚拟机会处理。
     * 2. 非运行时异常就必须得捕获了，否则编译不过去，java编译器要求程序员必须对这种异常进行catch,
     * Java认为Checked异常都是可以被处理（修复）的异常，所以Java程序必须显式处理Checked异常。
     */
}
