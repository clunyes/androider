package sourcecode.glide.glideold;

public class glidewith {
    /**
     * Glide的加载流程可以概括为以下流程：
     *
     * model(数据源)-->data(转换数据)-->decode(解码)-->transformed(缩放)-->transcoded(转码)-->encoded(编码保存到本地)
     *
     * 其中，transformed为对解码得到的图片数据进行缩放，如FitCenter、CropCenter等。
     *
     * 温馨提示，glide代码非常容易陷进去，所以掌握核心思路即可，因为用了太多设计模式，所以代码很绕。
     */
    /**
     * 1. glide with过程
     *
     * 双重判空单例
     * initializeGlide
     * 装载注册glidemodule
     * （glidemodule:如设置缓存的存储位置，缓存区的大小，网络加载模块等等，那么我们通常就是使用GldieModule进行配置。）
     * Glide glide = builder.build(applicationContext);
     * 在这个新建过程中，Glide建立了资源请求线程池，本地缓存加载线程池，动画线程池，内存缓存器，
     * 磁盘缓存工具等等，接着构造了Engine数据加载引擎，最后再将Engine注入Glide，构建Glide。
     *
     * 在构构造函数中，最后初始化了解码器，转码器，编码器，并将对各种类型进行一一注册
     *
     * RequestManagerRetriever的目的Glide是通过在页面中添加一个Fragment来动态监听页面的创建和销毁，从而达到依赖页面生命周期，动态管理请求的目的。
     *
     *
     *
     */
}
