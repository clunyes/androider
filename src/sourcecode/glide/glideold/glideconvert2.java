package sourcecode.glide.glideold;

public class glideconvert2 {
    /**
     * 那么，先把String对应的类型转换以及相应的工厂列出来
     * Model 	转换类型 	ModelLoader工厂
     * String.class 	InputStream.class 	DataUrlLoader.StreamFactory
     * String.class 	InputStream.class 	StringLoader.StreamFactory
     * String.class 	InputStream.class 	StringLoader.FileDescriptorFactory()
     *
     *
     *
     */

    /*synchronized <Model> List<ModelLoader<Model, ?>> build(Class<Model> modelClass) {
        try {
            List<ModelLoader<Model, ?>> loaders = new ArrayList<>();
            //1:遍历所有注册的模型转换器
            for (Entry<?, ?> entry : entries) {
                //2:过滤重复
                if (alreadyUsedEntries.contains(entry)) {
                    continue;
                }
                //3:如果是要转换的数据类型
                if (entry.handles(modelClass)) {
                    alreadyUsedEntries.add(entry);
                    //4:添加构建好的ModelLoader
                    loaders.add(this.<Model, Object>build(entry));
                    alreadyUsedEntries.remove(entry);
                }
            }
            return loaders;
        } catch (Throwable t) {
            alreadyUsedEntries.clear();
            throw t;
        }
    }

    private <Model, Data> ModelLoader<Model, Data> build(Entry<?, ?> entry) {
        //调用工厂方法构建ModelLoader
        return (ModelLoader<Model, Data>) Preconditions.checkNotNull(entry.factory.build(this));
    }

    //判断数据类型是否为要查找的数据类型，或者父类
    //即this.modelClass == modelClass 或者 modelClass为this.modelClass的子类
    public boolean handles(Class<?> modelClass) {
        return this.modelClass.isAssignableFrom(modelClass);
    }*/

    /**
     * 查看这个类DataUrlLoader
     * 看到这里已经很懵逼了
     *
     * 这就是Gilde数据模型转换非常高明的地方了。这里不仅将String.class类型的数据转换成了Uri.class的数据，并且还精确缩小了搜索范围，
     * 即要输入为Uri，又要输出只为InputStream.class和ParcelFileDescriptor.class的ModelLoader。
     *
     * 通过这种数据类型转换的能力，Glide几乎可以无缝的加载任意类型的图片数据。
     * 再次调用回MultiModelLoaderFactory.build(Class<Model> modelClass,Class<Data> dataClass)
     *
     * 经过这么一转换，分化出来的ModelLoader就有七八个。但是每个loader都有其对应可以加载数据类型，又或者在构建LoadData的时候会有所判断，
     * 来真正确认是否可以加载目标类型数据。
     *
     *
     *model 	data 	Factory
     Uri.class 	InputStream.class 	HttpUriLoader.Factory
     Uri.class 	InputStream.class 	UriLoader.StreamFactory
     Uri.class 	InputStream.class 	AssetUriLoader.StreamFactory
     Uri.class 	InputStream.class 	MediaStoreImageThumbLoader.Factory
     Uri.class 	InputStream.class 	MediaStoreVideoThumbLoader.Factory
     Uri.class 	ParcelFileDescriptor.class 	AssetUriLoader.FileDescriptorFactory
     *
     *  //HttpUriLoader#Factory.java
     public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiFactory) {
     return new HttpUriLoader(multiFactory.build(GlideUrl.class, InputStream.class));
     }
     *又继续转换了，这回变成了GlideUrl和InputStream，但是这次不一样了，因为这两个构成的Modeloader只有一个，并且还是实际干活的！
     *model 	data 	Factory
     *GlideUrl.class 	InputStream.class 	HttpGlideUrlLoader.Factory
     *
     *
     * 经过这一些列遍历和转换构建，最终，Glide将得到一个ModelLoader列表，这个列表可能包含ModelLoader或者MultiModelLoader，
     * 取决于要加载的Model数据在注册表中注册的ModelLoad，以及ModelLoader相互间可发生的转换。(注册就是开始初始化做的注册工作)
     *
     *
     *
     */

}
