package android.基础.主线程刷新ui;

public class 什么要主线程刷新ui {
    /**
     * “Android UI操作并不是线程安全的”这句话，个人理解是如果ViewRootImpl不强制检查线程，
     * 那么，任何都可以更改View的属性，无法保证同一帧数据的完整性。
     * 或许控制View绘制的线程和通知View更新的线程必须是同一线程，比主线程更新UI更能表达出这层一次吧。
     */
}
