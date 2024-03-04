# Android内存泄漏案例
产生的原因: 一个长生命周期的对象持有一个短生命周期对象的引用，通俗点讲就是该回收的对象，
因为引用问题没有被回收，最终会产生 OOM。

### Android 中常见的内存泄漏经典案例及解决方法
1. 单例

**示例 :**

```Plain Text
public class AppManager {

    private static AppManager sInstance;
    private CallBack mCallBack;
    private Context mContext;

    private AppManager(Context context) {
        this.mContext = context;
    }

    public static AppManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new AppManager(context);
        }
        return sInstance;
    }

    public void addCallBack(CallBack call){
        mCallBack = call；
    }
}


```
1. 通过上面的单列，如果 context 传入的是 Activity , Service 的 this，那么就会导致内存泄漏。

以 Activity 为例，当 Activity 调用 getInstance 传入 this，那么 sInstance 就会持有 Activity 的引用，
当 Activity 需要关闭的时候需要 回收的时候，发现 sInstance 还持有 没有用的 Activity 引用，
导致 Activity 无法被 GC 回收，就会造成内存泄漏

2. addCallBack(CallBack call) 这样写看起来是没有毛病的。但是当这样调用在看一下勒。

```Plain Text
//在 Activity 中实现单例的回调
AppManager.getInstance(getAppcationContext()).addCallBack(new CallBack(){
    @Override
    public void onStart(){

    }
})；


```
这里的 new CallBack()匿名内部类 默认持有外部的引用，造成 CallBack 释放不了，那么怎么解决了，请看下面解决方法

**解决方法**:

1. getInstance(Context context) context 都传入 Appcation 级别的 Context,
或者实在是需要传入 Activity 的引用就用 WeakReference 这种形式。
2. 匿名内部类建议大家单独写一个文件或者

```Plain Text
public void addCallBack(CallBack call){
        WeakReference<CallBack> mCallBack= new WeakReference<CallBack>(call)；
    }


```
2. Handler

**示例:**

```Plain Text
//在 Activity 中实现 Handler
class MyHandler extends Handler{
    private Activity m;
    public MyHandler(Activity activity){
        m=activity;
    }

//    class.....
}


```
这里的 MyHandler 持有 activity 的引用，当 Activity 销毁的时候，导致 GC 不会回收造成 内存泄漏。

**解决方法**:

```Plain Text
1.使用静态内部类 + 弱引用
2.在 Activity onDestoty() 中处理  removeCallbacksAndMessages() 
    @Override
    protected void onDestroy() {
        super.onDestroy();
    if(null != handler){
          handler.removeCallbacksAndMessages(null);
          handler = null;
    }
 }


```
3. 静态变量

**示例:**

```Plain Text
public class MainActivity extends AppCompatActivity {

    private static Police sPolice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (sPolice != null) {
            sPolice = new Police(this);
        }
    }
}

class Police {
    public Police(Activity activity) {
    }
}


```
这里 Police 持有 activity 的引用，会造成 activity 得不到释放，导致内存泄漏。

**解决方法**:

```Plain Text
//1. sPolice 在 onDestory（）中 sPolice = null;
//2. 在 Police 构造函数中 将强引用 to 弱引用；


```
4. 非静态内部类

参考 第二点 Handler 的处理方式

5. 匿名内部类

**示例:**

```Plain Text
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          new Thread(){
             @Override
             public void run() {
                super.run();
                        }
                    };
    }
}


```
很多初学者都会像上面这样新建线程和异步任务，殊不知这样的写法非常地不友好，
这种方式新建的子线程`Thread`和`AsyncTask`都是匿名内部类对象，默认就隐式的持有外部`Activity`的引用，导致`Activity`内存泄露。

**解决方法**:

```Plain Text
//静态内部类 + 弱引用
//单独写一个文件 + onDestory  = null;


```
6. 未取消注册或回调

**示例:**

```Plain Text
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(mReceiver, new IntentFilter());
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO ------
        }
    };
}


```
在注册观察则模式的时候，如果不及时取消也会造成内存泄露。
比如使用`Retrofit + RxJava`注册网络请求的观察者回调，
同样作为匿名内部类持有外部引用，所以需要记得在不用或者销毁的时候取消注册。

**解决方法**:

```Plain Text
//Activity 中实现 onDestory（）反注册广播得到释放
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(mReceiver);
    }


```
7. 定时任务

**示例:**

```Plain Text
public class MainActivity extends AppCompatActivity {

    /**模拟计数*/
    private int mCount = 1;
    private Timer mTimer;
    private TimerTask mTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mTimer.schedule(mTimerTask, 1000, 1000);
    }

    private void init() {
        mTimer = new Timer();
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        addCount();
                    }
                });
            }
        };
    }

    private void addCount() {
      mCount += 1;
    }
}


```
当我们`Activity`销毁的时，有可能`Timer`还在继续等待执行`TimerTask`，
它持有Activity 的引用不能被 GC 回收，因此当我们 Activity 销毁的时候要立即`cancel`掉`Timer`和`TimerTask`，以避免发生内存泄漏。

**解决方法**:

```Plain Text
//当 Activity 关闭的时候，停止一切正在进行中的定时任务，避免造成内存泄漏。
    private void stopTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        if (mTimerTask != null) {
            mTimerTask.cancel();
            mTimerTask = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimer();
    }


```
8. 资源未关闭

**示例:**

```Plain Text
ArrayList,HashMap,IO,File,SqLite,Cursor 等资源用完一定要记得 clear remove 等关闭一系列对资源的操作。


```
**解决方法**:

```Plain Text
用完即刻销毁


```
9. 属性动画

**示例:**

```Plain Text
动画同样是一个耗时任务，比如在 Activity 中启动了属性动画 (ObjectAnimator) ，
但是在销毁的时候，没有调用 cancle 方法，虽然我们看不到动画了，但是这个动画依然会不断地播放下去，
动画引用所在的控件，所在的控件引用 Activity ，这就造成 Activity 无法正常释放。
因此同样要在Activity 销毁的时候 cancel 掉属性动画，避免发生内存泄漏。
```
**解决方法**:

```Plain Text
@Override
protected void onDestroy() {
    super.onDestroy();
    //当关闭 Activity 的时候记得关闭动画的操作
    mAnimator.cancel();
}


```
10. Android 源码或者第三方 SDK

**示例:**

```Plain Text
//如果在开发调试中遇见 Android 源码或者 第三方 SDK 持有了我们当前的 Activity 或者其它类，那么现在怎么办了。


```
**解决方法**:

```Plain Text
//当前是通过 Java 中的反射找到某个类或者成员，来进行手动 = null 的操作。

```
