package android.window;

public class activityWindowView {
    /**
     * Window如何跟Activity关联？
     * 每一个Activity都包含了唯一一个PhoneWindow，
     * 这个就是Activity根Window（之所以是说根Window是因为在它上面可以增加更多其他的Window，例如：弹出框（dialog））
     */
    /**
     * 来个最简单的，setContentView其实就让View与Window关联。
     */
    /**
     * performLaunchActivity里面做了很多Activity启动过程具体的操作，例如：主题、记录Activity栈、执行Activity onCreate 方法等。
     *
     * Window怎么对View操控的呢:Window对View的操作是通过WindowManager来处理的。WindowManager提供在Window上添加View、移除View、更新View的操作。
     *
     */
    /**
     *
     * Activity包含了一个PhoneWindow，而PhoneWindow就是继承于Window的，Activity通过setContentView将View设置到了PhoneWindow上，
     * 而View通过WindowManager的addView()、removeView()、updateViewLayout()对View进行管理。
     * Window的添加过程以及Activity的启动流程都是一次IPC的过程。Activity的启动需要通过AMS完成；Window的添加过程需要通过WindowSession完成。
     *
     */
}
