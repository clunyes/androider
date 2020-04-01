package sourcecode.retrofit;

public class 详细理解 {
    /**
     * 好，大概就将这么多啦。这些就是retrofit的解耦套路了。通过一系列的设计模式，封装思想来解耦，看到现在，
     * 其实retrofit就是一个负责调度的controller。先给retrofit配置好，让它能够正常工作。
     * 你给它一个方法调用，它就在内部开始运转。这个方法以前我消化过吗，没消化那就用一个ServiceMethod来解析它。
     * 解析后要用来配置一个request请求。但它自己搞不定这事啊，所以需要给它一个转接头，通过转接头来使用okhttpcall。
     * 请求是做好了，但是response它又不认识，所以又请来convertor来帮忙，转换完毕之后才吐出一个我们最终要的那个对象。
     *
     */
}
