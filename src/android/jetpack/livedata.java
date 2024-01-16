package android.jetpack;

public class livedata {
    /**
     * 1.首先LiveData其实与数据实体类(POJO类)是一样的东西,它负责暂存数据.
     *
     * 2.其次LiveData其实也是一个观察者模式的数据实体类,它可以跟它注册的观察者回调数据是否已经更新.
     *
     * 3.LiveData还能知晓它绑定的Activity或者Fragment的生命周期,它只会给前台活动的activity回调(这个很厉害).
     * 这样你可以放心的在它的回调方法里直接将数据添加到View,而不用担心会不会报错.(你也可以不用费心费力判断Fragment是否还存活)
     *
     * LiveData生命周期感知能力确保 LiveData仅仅去更新那些处于生命周期活动状态的观察者
     * (应该说是去回调处于活动状态的activity或者fragment)。
     *
     * 和viewmodel配合使用
     */

    /**
     * liveData 与 MutableLiveData 区别
     * LiveData是抽象类它的setValue与postValue 方法都是protected关键字, 而MutableLiveData是继承LiveData后将setValue与postValue都public了.
     * liveData对外不暴露setValue与postValue，MutableLiveData则暴露两个方法
     *
     * 对LiveData封装去除粘性
     */
}
