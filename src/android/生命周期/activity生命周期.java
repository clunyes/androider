package android.生命周期;

public class activity生命周期 {
    /**
     *  1.onCreate:
     *  表示Activity正在被创建。在这函数中，可以做一些初始化工作，比如调用setContentVIew
     *      来加载界面布局资源,但是不建议做一些比较耗时的工作。
     *
     *  2.onRestart:
     *  表示Activity正在重新启动。一般是Activity由不可见变成可见时出发此函数
     *
     *  3.onStart:
     *  表示Activity正在被启动，即将开始。在这个过程中，Activity已经可见，只是还没有位于前台，
     *  能与用户进行交互
     *
     *  4. onResume:
     *  表示Activity已经可见，并且位于前台，可以开始活动，且可与用户进行交互
     *
     *  5.onPause:
     *  表示Activity正在暂停(停止),正常情况下，接下来会执行 onStop() 周期函数
     *
     *  6.onStop:
     *  表示Activity即将停止，可以做一些轻量级资源回收释放工作，同时不建议做耗时操作
     *
     *  7.onDestroy:
     *  表示Activity即将销毁，这是Activity的生命周期的最后一个函数，可以做一会回收工作和最终资
     */

    /**
     * 触发异常生命周期原因（onSaveInstanceState，onRestoreInstanceState）
     * onSaveInstanceState的调用遵循一个重要原则，即当系统“未经你许可”时销毁了你的activity，则onSaveInstanceState会被系统调用，
     * 这是系统的责任，因为它必须要提供一个机会让你保存你的数据。
     *
     */
}