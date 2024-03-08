应用性能管理（Application Performance Management）
该库原理涉及很底层，只适合建议，面试不适合讲。
Matrix-android 当前监控范围包括：应用安装包大小，帧率变化，启动耗时，卡顿，慢方法，SQLite 操作优化，文件读写，内存泄漏等等。

    APK Checker: 针对 APK 安装包的分析检测工具，根据一系列设定好的规则，
    检测 APK 是否存在特定的问题，并输出较为详细的检测结果报告，用于分析排查问题以及版本追踪
    Resource Canary: 基于 WeakReference 的特性和 Square Haha 库开发的 Activity 泄漏和 Bitmap 重复创建检测工具
    Trace Canary: 监控界面流畅性、启动耗时、页面切换耗时、慢函数及卡顿等问题
    SQLite Lint: 按官方最佳实践自动化检测 SQLite 语句的使用质量
    IO Canary: 检测文件 IO 问题，包括：文件 IO 监控和 Closeable Leak 监控

其中最重要的是Trace Canary，流畅性卡顿，直击痛点。
这里的功能，都可以作为插件引入使用。如下官网示例

```
  Matrix.Builder builder = new Matrix.Builder(application); // build matrix
  builder.pluginListener(new TestPluginListener(this)); // add general pluginListener
  DynamicConfigImplDemo dynamicConfig = new DynamicConfigImplDemo(); // dynamic config
  
  // init plugin 
  IOCanaryPlugin ioCanaryPlugin = new IOCanaryPlugin(new IOConfig.Builder()
                    .dynamicConfig(dynamicConfig)
                    .build());
  //add to matrix               
  builder.plugin(ioCanaryPlugin);
  
  //init matrix
  Matrix.init(builder.build());

  // start plugin 
  ioCanaryPlugin.start();
```