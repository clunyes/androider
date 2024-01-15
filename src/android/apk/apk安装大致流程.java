package android.apk;

public class apk安装大致流程 {
    /**
     *
     * 拷贝apk到指定的目录
     * 解压apk、拷贝文件、创建应用的数据目录
     * 解析AndroidManifest,拿到构成此APP的各组件信息，以及启动信息
     * 为每个APP分配UID、GID，以此创建APP运行的进程，这涉及Android的沙箱模型，可以理解为应用程序资源归属问题的解决
     * 更新应用程序权限
     *
     */
}
