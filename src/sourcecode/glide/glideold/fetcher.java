package sourcecode.glide.glideold;

public class fetcher {
    /**
     * 看到这里不禁mmp啊，回调的太深了
     *
     * 得到了LoadData后，回到SourceGenerotor中，
     *
     *通过loadDataWithRedirects方法，利用HttpURLConnection就可以抓取到网络图片的InputStream，具体不再展开，有兴趣可以查看源码。(这里应该加入一个解码过程，解码之后再进入缓存)
     * 最后通过callback.onDataReady(result)将结果回调给SourceGenerator进行下一步处理。
     *
     * 获取到数据后，分两种情况，一是需要将图片缓存到本地硬盘，一种是不需要缓存。Glide配置了多种缓存策略，默认是自动智能切换缓存存储策略，
     * Glide认为远程网络图片获取是昂贵的，所以默认网络图片是会缓存原图的。而本地图片，包括drawable/assets等是不会缓存原图的。（当然你也可以重新配置）
     *
     *
     * 最后，来总结一下Glide整个的数据转换与抓取流程：
     * Glide利用线程池的方式，将每一个解码过程都封装为一次解码任务。
     * 整个数据抓取过程中，Glide会尝试从内存到处理过的图片缓存，再到原图缓存，最后到远程图片等四个地方进行数据加载。（这里的远程图片包括drawable/assets等资源）
     * 数据模型转换时，根据Glide初始化时注册的模型转换注册表，将原始model模型数据转换为可能的数据模型，并尝试使用这些模型来抓取数据，直至抓取到数据，或抓取失败返回。
     * Glide数据转模型使得Glide有非常好的拓展性和重用性。
     * 整个数据转换和抓取流程非常复杂，但是只要抓住其中一个源头，并跟踪下去，其实还是非常清晰的，也可以看到Glide设计的优雅高明之处。
     *
     *
     */

  /*  HttpUrlFetcher.java

    public void loadData(@NonNull Priority priority,
                         @NonNull DataCallback<? super InputStream> callback) {
        long startTime = LogTime.getLogTime();
        try {
            InputStream result = loadDataWithRedirects(glideUrl.toURL(), 0, null, glideUrl.getHeaders());
            callback.onDataReady(result);
        } catch (IOException e) {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                Log.d(TAG, "Failed to load data for url", e);
            }
            callback.onLoadFailed(e);
        } finally {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(startTime));
            }
        }
    }*/

  /*  SourceGenerator.java

    public void onDataReady(Object data) {
        DiskCacheStrategy diskCacheStrategy = helper.getDiskCacheStrategy();
        if (data != null && diskCacheStrategy.isDataCacheable(loadData.fetcher.getDataSource())) {
            dataToCache = data;
            // We might be being called back on someone else's thread. Before doing anything, we should
            // reschedule to get back onto Glide's thread.
            cb.reschedule();
        } else {
            cb.onDataFetcherReady(loadData.sourceKey, data, loadData.fetcher,
                    loadData.fetcher.getDataSource(), originalKey);
        }
    }*/
}
