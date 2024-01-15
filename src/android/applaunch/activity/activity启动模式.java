package android.applaunch.activity;

public class activity启动模式 {
    /**
     * 标准模式（standard）
     * 栈顶复用模式（singleTop）
     *
     * 如果新启动的Activity已经位于任务战的栈顶，那么此Activity不会被重新创建，只会重新调用 onNewIntent 方法，
     * 这个Activity的onCreate、onStart都不会被系统调用。
     * 如果新Activity实例已经存在但不在栈顶，那么重新创建 Activity 并放入栈顶。
     *
     * 栈内复用模式（singleTask）
     *
     * 栈内复用模式：这是一种单实例模式，一个栈中同一个Activity只存在唯一一个实例，无论是否在栈顶，只要存在实例，
     * 都不会重新创建，和 singleTop 一样会重新调用 onNewIntent 方法。需要注意的是：如果一个Activity被设置为singleTask模式，
     * 那么当栈内已经存在该Activity实例时，再启动该Activity，会让该Activity实例之上的Activity被出栈。
     *
     *
     * 单例模式（singleInstance）
     * 独占一个栈，且栈内只有这个activity。
     * 作为外部App调用自己客户端程序的入口的Activity都会采用singleInstance启动模式。
     */
}
