package android.jetpack;

public class livedata {
    /**
     * 请确保将用于更新界面的 LiveData 对象存储在 ViewModel 对象中，而不是将其存储在 Activity 或 Fragment 中，原因如下：
     * 1.避免 Activity 和 Fragment 过于庞大。现在，这些界面控制器负责显示数据，但不负责存储数据状态。
     * 2.将 LiveData 实例与特定的 Activity 或 Fragment 实例分离开，并使 对象在配置更改后继续存在。
     *
     * LiveData生命周期感知能力确保 LiveData仅仅去更新那些处于生命周期活动状态的观察者
     * (应该说是去回调处于活动状态的activity或者fragment)。
     *
     * 和viewmodel配合使用
     */
}
