package android.动态化.热修复;

public class 为什么要multidex {
    /**
     * 我们应用的方法数没有超过65536，但是加上依赖的jar包，框架等，超过了65536
     * （根据方案一的结果，我们应用方法数是65579，那我们删掉200个方法，就小于65536）
     *
     * 存方法数的字段为short，存不下了
     * Google在2014年提出了multidex的解决方案，这个方案主要是针对AndroidStudio和Gradle编译环境的，
     * 将一个dex文件拆成两个或多个dex文件。
     */
}
