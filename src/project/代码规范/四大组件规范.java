package project.代码规范;

public class 四大组件规范 {
    /**
     * 1. 数据量比较大避免使用intent+parcelable，在海小豚中，不使用eventbus，使用仓库概念
     * 2. activity跳转，都用arouter
     * 3. 避免在service中，broadcastReceiver（广播用显式的intent）处理耗时方法
     * 4. application初始化判断进程，有些sdk会开新进程
     * 5. 在onpause onstop时关闭动画
     */
}
