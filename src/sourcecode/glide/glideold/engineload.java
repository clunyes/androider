package sourcecode.glide.glideold;

public class engineload {
    /**
     * 1:创建资源索引key EngineKey
     * 2:从内存中当前正在显示的资源缓存加载图片 EngineResource
     * 3:从内存缓存资源中加载图片 EngineResource
     * 4:获取已经存在的加载任务 EngineJob
     * 5:新建加载任务，用于启动解码任务 EngineJob
     * 6:新建解码任务，真正执行数据加载和解码的类 DecodeJob
     * 7:缓存加载任务
     * 8:开启解码任务 engineJob.start(decodeJob);
     *
     * 可以看到，decodeJob是真正去获取数据的，enginejob负责调度decodejob
     * Glide将每一个请求都封装为一个解码任务DecodeJob，并扔到线程池中，以此来开启任务的异步加载。
     * decode run-->runWrapped 具体方法不必细读，
     *
     * 做的事情：
     * 尝试从处理过的本地资源加载图片 ResourceCacheGenerator
     * 尝试从未处理过的原始本地资源加载图片 DataCacheGenerator
     * 尝试从远程加载图片 SourceGenerator
     *
     * 下一篇 convert
     *
     */
    /**
     * 详细分析
     * 1：创建资源索引key。
     * 我们可以看到生成一个索引key需要资源本身、图片宽高、转换类型、加载参数等等，只要这些都一致的情况下，才判定为一个相同的图片资源加载。
     * 所以，即便是要显示的ImageView宽高不一样，Glide都会重新执行一次加载过程，而不是内存中加载已有的图片资源。
     *
     * 2和3：
     * 如果要加载的图片已经正在显示，直接使用已有的资源。如果图片没有在显示，但是已经正好还在内存缓存中，没有被销毁，那么直接使用缓存中的资源
     *
     * 4-8如果内存中并没有可以直接使用的图片资源，那么就要开始从网络或者本地硬盘中去加载一张图片。
     *
     *
     */
}
