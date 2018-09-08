package sourcecode.glide;

public class dataconvert {
    /**
     * 数据模型转换
     *
     * SourceGenerator startNext,嗯，在获取了loadData后，我们再次回到这里loadData.fetcher,正式开始load，进入fetcher文章
     *
     * 1：判断是否有缓存，如有，直接加载缓存
     * 2：没有缓存，从远程加载
     * 3：获取数据加载器(什么是数据加载器)
     *
     *
     * 代码如下
     *
     * 继续，关注loadData = helper.getLoadData().get(loadDataListIndex++);这条代码
     *---->decodeHelper getLoadData------->ModelLoaderRegistry.getModelLoaders-------------------->ModelLoaderRegistry.getModelLoadersForClass
     * ---------------->multiModelLoaderFactory.build
     *
     * 经历了convert2文件中的种种转换，得到ModelLoader后，将利用这些ModelLoader逐个构建LoadData（即步骤3），那么怎么构建这个
     * loadData（且看glideLoaddata），不得不说设计的很好，但是读起来好绕，直接搞个状态机不好吗。。。。
     *
     */
    //SourceGenerator.java

   /* public boolean startNext() {

        //1：判断是否有缓存，如有，直接加载缓存
        if (dataToCache != null) {
            Object data = dataToCache;
            dataToCache = null;
            cacheData(data);
        }

        if (sourceCacheGenerator != null && sourceCacheGenerator.startNext()) {
            return true;
        }
        sourceCacheGenerator = null;

        //2：没有缓存，从远程加载
        loadData = null;
        boolean started = false;
        while (!started && hasNextModelLoader()) {
            //3：获取数据加载器
            loadData = helper.getLoadData().get(loadDataListIndex++);
            if (loadData != null
                    && (helper.getDiskCacheStrategy().isDataCacheable(loadData.fetcher.getDataSource())
                    || helper.hasLoadPath(loadData.fetcher.getDataClass()))) {
                started = true;
                loadData.fetcher.loadData(helper.getPriority(), this);
            }
        }
        return started;
    }*/



    /**
     * 数据加载器概念
     *
     * SourceGenerator继承DataFetcherGenerator---- 	DataFecher生成器
     * ModelLoader--------------------------------- 数据转换和创建LoadData
     * LoadData-------------------------------- 	数据加载(包含DataFecher)
     * DataFecher------------------------------ 	数据抓取
     * LoadPath-------------------------------- 	加载器包含多个DecodePath
     * DecodePath------------------------------ 	解码器
     *
     *
     * 以上1-4构成了Glide数据转换与获取（如：String –> url –> InputStream）的核心；
     * 5-6则构成Glide数据解码的核心（5-6我们在下一篇文章再详细分析）。
     */
}
