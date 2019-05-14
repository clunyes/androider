package sourcecode.glide;
/**
 * Glide的加载流程可以概括为以下流程：
 *
 * model(数据源)-->data(转换数据)-->decode(解码)-->transformed(缩放)-->transcoded(转码)-->encoded(编码保存到本地)
 *
 * 其中，transformed为对解码得到的图片数据进行缩放，如FitCenter、CropCenter等。
 *
 */

/**
 * glide with 初始化glide配置，缓存配置(缓存大小，内存缓存，磁盘缓存)，生命周期的绑定（当前添加一个fragment，使用ActivityFragmentLifecycle注入监听），engine对象，数据转换器/解码器/转码器/编码器，最后返回RequestManager load(网络图片，本地图片，等等)，返回RequestBuilder
 *
 * apply requestOption 一些配置，展位图，展示形式
 *
 * into就是具体去请求数据，到加载数据的全部流程
 *
 * Target--Request--onSizeReady--engine.load--（没有缓存，启动线程池开始加载）engineJob.start--DecodeJob.run--HttpUrlFetcher(网络请求)--stream--decodeJob.decodeFromRetrievedData--Resource<Bitmap>
 *                                          --（有缓存）onResourceReady
 *
 */
