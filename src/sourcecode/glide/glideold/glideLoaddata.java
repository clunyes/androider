package sourcecode.glide.glideold;

public class glideLoaddata {
    /**
     * 那怎么构建这个loaddata呢
     *
     *
     *
     * MultiModelLoader会遍历保存的ModelLoader列表，逐个构建LoadData，并将各个LoadData中的DataFetcher取出，
     * 存放在MultiFetcher中，从而MultiFetcher又成为一个协调器。
     *
     * 其实最后构建的就是实际干活的对象：HttpGlideUrlLoader
     *
     * 最后的代码，将新建的HttpUrlFetcher注入给了LoadData，至此，得到一个有效的LoadData和DataFetcher。
     *
     *
     */

   /*MultiModelLoader.java
    public LoadData<Data> buildLoadData(Model model, int width, int height,
                                        Options options) {
        Key sourceKey = null;
        int size = modelLoaders.size();
        List<DataFetcher<Data>> fetchers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ModelLoader<Model, Data> modelLoader = modelLoaders.get(i);
            if (modelLoader.handles(model)) {
                LoadData<Data> loadData = modelLoader.buildLoadData(model, width, height, options);
                if (loadData != null) {
                    sourceKey = loadData.sourceKey;
                    fetchers.add(loadData.fetcher);
                }
            }
        }
        return !fetchers.isEmpty()
                ? new LoadData<>(sourceKey, new MultiFetcher<>(fetchers, exceptionListPool)) : null;
    }*/

/*    HttpGlideUrlLoader.java

    public LoadData<InputStream> buildLoadData(@NonNull GlideUrl model, int width, int height,
                                               @NonNull Options options) {
        // GlideUrls memoize parsed URLs so caching them saves a few object instantiations and time
        // spent parsing urls.
        GlideUrl url = model;
        if (modelCache != null) {
            url = modelCache.get(model, 0, 0);
            if (url == null) {
                modelCache.put(model, 0, 0, model);
                url = model;
            }
        }
        int timeout = options.get(TIMEOUT);
        return new LoadData<>(url, new HttpUrlFetcher(url, timeout));
    }*/

}
