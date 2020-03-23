package design_pattern.behavioral_design_pattern.mediator;
/**
 * mediator中介者模式：定义一个中介对象来封装系列对象之间的交互。调度系统内部不同模块的互相调用,大家都通过中介者.
 * 外观模式是,系统提供统一的操作方式,给外部来调用.
 */
/**
 * 中介者，相当于电脑中的主板，所有cpu显卡内存都往主板上集成
 */
/**
 * Android中的锁屏功能就用到了中介者模式，KeyguardService（锁屏服务）通过KeyguardViewMediator（锁屏中介者）
 * 来协调各种Manager的状态以达到锁屏的功能。这里KeyguardService和各种Manager等等都充当了同事的角色。
 *
 *         private AlarmManager mAlarmManager;
 *         private AudioManager mAudioManager;
 *         private StatusBarManager mStatusBarManager;
 *         private PowerManager mPM;
 *         private IWindowManager mWM;
 *         private TrustManager mTrustManager;
 *         private SearchManager mSearchManager;
 *         private PowerManager.WakeLock mShowKeyguardWakeLock;
 *         private StatusBarKeyguardViewManager mStatusBarKeyguardViewManager;
 */
