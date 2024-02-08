# Activity启动流程变化
发现最新的Android9.0源码中startActivity启动Activity的流程相比于低版本的Android源码来说改动较大。



### 1\. Activity启动方式
```Plain Text
//startActivity
Intent intent = new Intent(ActivityA 实例, ActivityB.class);
startActivity(intent);
//startActivityForResult
startActivityForResult(intent,REQUEST_CODE);
复制代码
```
### 2\. Activity启动流程分析
假设ActivityA 启动ActivityB

```Plain Text
1，`Activity#startActivityForResult`：
2，`Instrumentation#execStartActivity`：
3，`ActivityTaskManagerService#startActivity`：
4，`ActivityTaskManagerService#startActivityAsUser`：
5，`ActivityStarter#execute`：
6，`ActivityStarter#startActivityInner`：
7，`RootWindowContainer#resumeFocusedStacksTopActivities`：
8，`ActivityStack#resumeTopActivityUncheckedLocked`：
9，`ActivityStack#resumeTopActivityInnerLocked`：
9.1 ，`ActivityStack#startPausingLocked`： 处理ActivityA的onPause
9.2 ，`ActivityStackSupervisor#startSpecificActivity`： 处理ActivityB的启动

复制代码
```
Activity#startActivity 方法

```Plain Text
public void startActivity(Intent intent) {
    this.startActivity(intent, null);
}

public void startActivity(Intent intent, @Nullable Bundle options) {
    if (options != null) {
        startActivityForResult(intent, -1, options);
    } else {
       //options = null所以会执行这个 ,requestCode = -1 
        startActivityForResult(intent, -1);
    }
}
复制代码
```
requestCode<0 表示正常启动Activity , requestCode不回调在onActivityResult()中 , 
所有startActivity最终都会调用startActivityForResult(@RequiresPermission Intent intent, int requestCode, Bundle options) 方法

```Plain Text
//Activity.java

//requestCode= -1 ,options = null 
public void startActivityForResult(@RequiresPermission Intent intent, int requestCode,
        @Nullable Bundle options) {
    if (mParent == null) {
        options = transferSpringboardActivityOptions(options);
        //mParent=null ,会调用 mInstrumentation.execStartActivity启动Activity
        Instrumentation.ActivityResult ar =
            mInstrumentation.execStartActivity(
                this, mMainThread.getApplicationThread(), mToken, this,
                intent, requestCode, options);
    } 
}
复制代码
```
Instrumentation 负责Activity的启动 , 以及相关生命周期方法的调用

Instrumentation#execStartActivity( Context who, IBinder contextThread, IBinder token, Activity target, Intent intent, int requestCode, Bundle options)

```Plain Text
//framework\base\core\java\android\app\Instrumentation.java

//who 为ActivityA 
//token 为ActivityA 的 token ,用于找到ActivityA 的ActivityRecord,ActivityClientRecord
//contextThread =ApplicationThread 继承自 IApplicationThread.Stub ,是AMS 调用 App 的桥梁
//target 为ActivityA 
//requestCode = -1 
public ActivityResult execStartActivity(
        Context who, IBinder contextThread, IBinder token, Activity target,
        Intent intent, int requestCode, Bundle options) {
    IApplicationThread whoThread = (IApplicationThread) contextThread;

    try {
        intent.migrateExtraStreamToClipData();
        intent.prepareToLeaveProcess(who);
        //调用AMS startActivity 方法
        int result = ActivityTaskManager.getService()
            .startActivity(whoThread, who.getBasePackageName(), intent,
                    intent.resolveTypeIfNeeded(who.getContentResolver()),
                    token, target != null ? target.mEmbeddedID : null,
                    requestCode, 0, null, options);
        checkStartActivityResult(result, intent);
    } catch (RemoteException e) {
        throw new RuntimeException("Failure from system", e);
    }
    return null;
}
复制代码
```
Client端通过ActivityTaskManager.getService()拿到Server端Binder代理对象 ,进行跨进程通信 , 然后调用ActivityManagerService#startActivity方法

```Plain Text
//framework\base\services\core\java\com\android\server\am\ActivityManagerService.java

 //resultTo 为ActivityA的token
 //resultWho 为ActivityA 的 mEmbeddedID ,mEmbeddedID在Activity中的attach中被赋值
 //requestCode =-1
 //startFlags = 0
 //profilerInfo = null
 //callingPackage为ActivityA的包名
  public int startActivity(IApplicationThread caller, String callingPackage,
            Intent intent, String resolvedType, IBinder resultTo, String resultWho, int requestCode,
            int startFlags, ProfilerInfo profilerInfo, Bundle bOptions) {
        return mActivityTaskManager.startActivity(caller, callingPackage, null, intent,
                resolvedType, resultTo, resultWho, requestCode, startFlags, profilerInfo, bOptions);
    }
复制代码
```
最终会调用ActivityTaskManagerService#startActivityAsUser

```Plain Text
  //framework\base\services\core\java\com\android\server\wm\ActivityTaskManagerService.java

   private int startActivityAsUser(IApplicationThread caller, String callingPackage,
            @Nullable String callingFeatureId, Intent intent, String resolvedType,
            IBinder resultTo, String resultWho, int requestCode, int startFlags,
            ProfilerInfo profilerInfo, Bundle bOptions, int userId, boolean validateIncomingUser) {
        assertPackageMatchesCallingUid(callingPackage);
        enforceNotIsolatedCaller("startActivityAsUser");

        userId = getActivityStartController().checkTargetUser(userId, validateIncomingUser,
                Binder.getCallingPid(), Binder.getCallingUid(), "startActivityAsUser");

        // 调用ActivityStarter#execute 方法
        return getActivityStartController().obtainStarter(intent, "startActivityAsUser")
                .setCaller(caller)
                .setCallingPackage(callingPackage)
                .setCallingFeatureId(callingFeatureId)
                .setResolvedType(resolvedType)
                .setResultTo(resultTo)
                .setResultWho(resultWho)
                .setRequestCode(requestCode)
                .setStartFlags(startFlags)
                .setProfilerInfo(profilerInfo)
                .setActivityOptions(bOptions)
                .setUserId(userId)
                .execute();

    }
复制代码
```
ActivityStarter#execute 方法中调用executeRequest执行Request

```Plain Text
//framework\base\services\core\java\com\android\server\wm\ActivityStarter.java

int execute() {
        try {
            //结果返回值
            int res;
            synchronized (mService.mGlobalLock) {
                res = resolveToHeavyWeightSwitcherIfNeeded();
                if (res != START_SUCCESS) {
                    return res;
                }
                //调用executeRequest方法
                res = executeRequest(mRequest);
            }
        }
    }
复制代码
```
ActivityStarter#executeRequest 方法

```Plain Text
//framework\base\services\core\java\com\android\server\wm\ActivityStarter.java


private int executeRequest(Request request) {

         //调用startActivityUnchecked
        mLastStartActivityResult = startActivityUnchecked(r, sourceRecord, voiceSession,
                request.voiceInteractor, startFlags, true /* doResume */, checkedOptions, inTask,
                restrictedBgActivity, intentGrants);

        return mLastStartActivityResult;
    }
复制代码
```
startActivityUnchecked方法中调用startActivityInner

```Plain Text
////framework\base\services\core\java\com\android\server\wm\ActivityStarter.java


 int startActivityInner(final ActivityRecord r, ActivityRecord sourceRecord,
            IVoiceInteractionSession voiceSession, IVoiceInteractor voiceInteractor,
            int startFlags, boolean doResume, ActivityOptions options, Task inTask,
            boolean restrictedBgActivity, NeededUriGrants intentGrants) {


        if (mDoResume) {
            final ActivityRecord topTaskActivity =
                    mStartActivity.getTask().topRunningActivityLocked();
            if (!mTargetStack.isTopActivityFocusable()
                    || (topTaskActivity != null && topTaskActivity.isTaskOverlay()
                    && mStartActivity != topTaskActivity)) {

                mTargetStack.getDisplay().mDisplayContent.executeAppTransition();
            } else {

                //调用RootWindowContainer的resumeFocusedStacksTopActivities方法
                mRootWindowContainer.resumeFocusedStacksTopActivities(
                        mTargetStack, mStartActivity, mOptions);
            }
        }

        return START_SUCCESS;
    }

复制代码
```
RootWindowContainer#resumeFocusedStacksTopActivities

```Plain Text
//framework\base\services\core\java\com\android\server\wm\RootWindowContainer.java

 boolean resumeFocusedStacksTopActivities(
            ActivityStack targetStack, ActivityRecord target, ActivityOptions targetOptions) {


        boolean result = false;
        if (targetStack != null && (targetStack.isTopStackInDisplayArea()
                || getTopDisplayFocusedStack() == targetStack)) {
            result = targetStack.resumeTopActivityUncheckedLocked(target, targetOptions);
        }

        for (int displayNdx = getChildCount() - 1; displayNdx >= 0; --displayNdx) {
            if (!resumedOnDisplay) {
                final ActivityStack focusedStack = display.getFocusedStack();
                if (focusedStack != null) {

                   //调用ActivityStack resumeTopActivityUncheckedLocked
                    result |= focusedStack.resumeTopActivityUncheckedLocked(target, targetOptions);

                } 
            }
        }

        return result;
    }
复制代码
```
ActivityStack#resumeTopActivityInnerLocked方法, prev为ActivityA 的ActivityRecord

```Plain Text
//framework\base\services\core\java\com\android\server\wm\ActivityStack.java


private boolean resumeTopActivityInnerLocked(ActivityRecord prev, ActivityOptions options) {

        if (mResumedActivity != null) {

            //调用startPausingLocked,执行ActivityA 的 onPause 方法
            pausing |= startPausingLocked(userLeaving, false /* uiSleeping */, next);
        }

         if (prev.attachedToProcess()) {
            try { 

            //调动StackSupervisor.startSpecificActivity
            //启动ActivityB
                mStackSupervisor.startSpecificActivity(next, true, false);
                return true;
            }

        return true;
    }
复制代码
```
#### 2.1 处理ActivityA 的onPause
**ActivityStack#startPausingLocked方法 ,暂停ActivityA**

```Plain Text
//framework\base\services\core\java\com\android\server\wm\ActivityStack.java

final boolean startPausingLocked(boolean userLeaving, boolean uiSleeping,
            ActivityRecord resuming) {

        if (prev.attachedToProcess()) {

            try {
              //prev 获取ActivityA 的ActivityRecord 
              //通过ActivityRecord能获取到ActivityA
              //prev.app.getThread() 为 ApplicationThread binder代理对象 , 执行scheduleTransaction
                mAtmService.getLifecycleManager().scheduleTransaction(prev.app.getThread(),
                        prev.appToken, PauseActivityItem.obtain(prev.finishing, userLeaving,
                                prev.configChangeFlags, pauseImmediately));
            } 
        }


}
复制代码
```
最终会调到ApplicationThread#scheduleTransaction 方法

```Plain Text
public void scheduleTransaction(ClientTransaction transaction) throws RemoteException {
            ActivityThread.this.scheduleTransaction(transaction);
        }

void scheduleTransaction(ClientTransaction transaction) {
        transaction.preExecute(this);
        sendMessage(ActivityThread.H.EXECUTE_TRANSACTION, transaction);
    }

  //执行到这里  
case EXECUTE_TRANSACTION:
                    final ClientTransaction transaction = (ClientTransaction) msg.obj;
                    mTransactionExecutor.execute(transaction);
                    if (isSystem()) {
                        // Client transactions inside system process are recycled on the client side
                        // instead of ClientLifecycleManager to avoid being cleared before this
                        // message is handled.
                        transaction.recycle();
                    }
复制代码
```
TransactionExecutor#execute 执行事务

```Plain Text
public void execute(ClientTransaction transaction) {
        if (DEBUG_RESOLVER) Slog.d(TAG, tId(transaction) + "Start resolving transaction");

        final IBinder token = transaction.getActivityToken();

        executeCallbacks(transaction);
        executeLifecycleState(transaction);

    }

public void executeCallbacks(ClientTransaction transaction) {
        final List<ClientTransactionItem> callbacks = transaction.getCallbacks();

        final IBinder token = transaction.getActivityToken();
        ActivityClientRecord r = mTransactionHandler.getActivityClient(token);


        final ActivityLifecycleItem finalStateRequest = transaction.getLifecycleStateRequest();
        final int finalState = finalStateRequest != null ? finalStateRequest.getTargetState()
                : UNDEFINED;

        final int lastCallbackRequestingState = lastCallbackRequestingState(transaction);

        final int size = callbacks.size();
        for (int i = 0; i < size; ++i) {
            final ClientTransactionItem item = callbacks.get(i);
            //执行execute 方法
            item.execute(mTransactionHandler, token, mPendingActions);
        }
    }
复制代码
```
PauseActivityItem#execute

```Plain Text
public void execute(ClientTransactionHandler client, IBinder token,
            PendingTransactionActions pendingActions) {
       // client 为ActivityThread
        client.handlePauseActivity(token, mFinished, mUserLeaving, mConfigChanges, 
    }
复制代码
```
#### 2.2 启动ActivityB
回到ActivityStack#resumeTopActivityInnerLocked方法 中 , **ActivityStackSupervisor#startSpecificActivity ,启动ActivityB**

```Plain Text
//framework\base\services\core\java\com\android\server\wm\ActivityStackSupervisor.java

  void startSpecificActivity(ActivityRecord r, boolean andResume, boolean checkConfig) {
        // Is this activity's application already running?
        final WindowProcessController wpc =
                mService.getProcessController(r.processName, r.info.applicationInfo.uid);

        if (wpc != null && wpc.hasThread()) {
            try {
                realStartActivityLocked(r, wpc, andResume, checkConfig);
                return;
            } catch (RemoteException e) {

            }

        }

    }

复制代码
```
realStartActivityLocked

```Plain Text
//framework\base\services\core\java\com\android\server\wm\ActivityStackSupervisor.java


 boolean realStartActivityLocked(ActivityRecord r, WindowProcessController proc,
            boolean andResume, boolean checkConfig) throws RemoteException {

        final Task task = r.getTask();
        final ActivityStack stack = task.getStack();

            try {

                // Create activity launch transaction.
                final ClientTransaction clientTransaction = ClientTransaction.obtain(
                        proc.getThread(), r.appToken);

                final DisplayContent dc = r.getDisplay().mDisplayContent;

                //添加LaunchActivityItem事务回调
                clientTransaction.addCallback(LaunchActivityItem.obtain(new Intent(r.intent),
                        System.identityHashCode(r), r.info,
                        // TODO: Have this take the merged configuration instead of separate global
                        // and override configs.
                        mergedConfiguration.getGlobalConfiguration(),
                        mergedConfiguration.getOverrideConfiguration(), r.compat,
                        r.launchedFromPackage, task.voiceInteractor, proc.getReportedProcState(),
                        r.getSavedState(), r.getPersistentSavedState(), results, newIntents,
                        dc.isNextTransitionForward(), proc.createProfilerInfoIfNeeded(),
                        r.assistToken, r.createFixedRotationAdjustmentsIfNeeded()));

                // Set desired final state.
                final ActivityLifecycleItem lifecycleItem;
                if (andResume) {
                //andResume = true
                    lifecycleItem = ResumeActivityItem.obtain(dc.isNextTransitionForward());
                } else {
                    lifecycleItem = PauseActivityItem.obtain();
                }
                clientTransaction.setLifecycleStateRequest(lifecycleItem);

                //调度事务 
                //通过binder 调ApplicationThread 的scheduleTransaction方法
                //启动ActivityB 并执行相关生命周期方法
                mService.getLifecycleManager().scheduleTransaction(clientTransaction);

             }  

        return true;
    }


复制代码
```
LaunchActivityItem#execute

```Plain Text
//framework\base\core\java\android\app\servertransaction\LaunchActivityItem.java

public void execute(ClientTransactionHandler client, IBinder token,
            PendingTransactionActions pendingActions) {
        ActivityClientRecord r = new ActivityClientRecord(token, mIntent, mIdent, mInfo,
                mOverrideConfig, mCompatInfo, mReferrer, mVoiceInteractor, mState, mPersistentState,
                mPendingResults, mPendingNewIntents, mIsForward,
                mProfilerInfo, client, mAssistToken, mFixedRotationAdjustments);
        client.handleLaunchActivity(r, pendingActions, null /* customIntent */);
    }

复制代码
```
ActivityThread#handleLaunchActivity 反射创建Activity并执行onCreate方法

```Plain Text
 public Activity handleLaunchActivity(ActivityClientRecord r,
            PendingTransactionActions pendingActions, Intent customIntent) {

        final Activity a = performLaunchActivity(r, customIntent);

        return a;
    }

复制代码
```
ActivityThread#performLaunchActivity 反射创建Activity 调用attach 设置主题 调用onCreate

```Plain Text
private Activity performLaunchActivity(ActivityClientRecord r, Intent customIntent) {
        ActivityInfo aInfo = r.activityInfo;
        if (r.packageInfo == null) {
            r.packageInfo = getPackageInfo(aInfo.applicationInfo, r.compatInfo,
                    Context.CONTEXT_INCLUDE_CODE);
        }

        ComponentName component = r.intent.getComponent();
        if (component == null) {
            component = r.intent.resolveActivity(
                mInitialApplication.getPackageManager());
            r.intent.setComponent(component);
        }

        if (r.activityInfo.targetActivity != null) {
            component = new ComponentName(r.activityInfo.packageName,
                    r.activityInfo.targetActivity);
        }

        ContextImpl appContext = createBaseContextForActivity(r);
        Activity activity = null;
        try {
            java.lang.ClassLoader cl = appContext.getClassLoader();
            //反射创建Activity 
            activity = mInstrumentation.newActivity(
                    cl, component.getClassName(), r.intent);
            StrictMode.incrementExpectedActivityCount(activity.getClass());
            r.intent.setExtrasClassLoader(cl);
            r.intent.prepareToEnterProcess();
            if (r.state != null) {
                r.state.setClassLoader(cl);
            }
        }
        try {
            Application app = r.packageInfo.makeApplication(false, mInstrumentation);

            if (activity != null) {
                CharSequence title = r.activityInfo.loadLabel(appContext.getPackageManager());
                Configuration config = new Configuration(mCompatConfiguration);
                if (r.overrideConfig != null) {
                    config.updateFrom(r.overrideConfig);
                }
                Window window = null;
                if (r.mPendingRemoveWindow != null && r.mPreserveWindow) {
                    window = r.mPendingRemoveWindow;
                    r.mPendingRemoveWindow = null;
                    r.mPendingRemoveWindowManager = null;
                }
                appContext.setOuterContext(activity);

                //调用attach方法
                activity.attach(appContext, this, getInstrumentation(), r.token,
                        r.ident, app, r.intent, r.activityInfo, title, r.parent,
                        r.embeddedID, r.lastNonConfigurationInstances, config,
                        r.referrer, r.voiceInteractor, window, r.configCallback,
                        r.assistToken);

                if (customIntent != null) {
                    activity.mIntent = customIntent;
                }
                r.lastNonConfigurationInstances = null;
                checkAndBlockForNetworkAccess();
                activity.mStartedActivity = false;
                int theme = r.activityInfo.getThemeResource();
                if (theme != 0) {
                    //设置主题
                    activity.setTheme(theme);
                }

                activity.mCalled = false;

                //调用onCreate方法
                if (r.isPersistable()) {
                    mInstrumentation.callActivityOnCreate(activity, r.state, r.persistentState);
                } else {
                    mInstrumentation.callActivityOnCreate(activity, r.state);
                }
                r.activity = activity;
            }
            //设置状态为ON_CREATE
            r.setState(ON_CREATE);

            synchronized (mResourcesManager) {
               //保存到mActivities中
                mActivities.put(r.token, r);
            }

        }

        return activity;
    }
复制代码
```
回到TransactionExecutor#execute 方法 ,executeCallbacks中处理完Activity的创建和调用onCreate方法 , 接着调用executeLifecycleState 处理onStart和onResume

```Plain Text
public void execute(ClientTransaction transaction) {
        if (DEBUG_RESOLVER) Slog.d(TAG, tId(transaction) + "Start resolving transaction");

        final IBinder token = transaction.getActivityToken();
        //这里处理完onCreate方法
        executeCallbacks(transaction);
        //接着处理onStart 和 onResume
        executeLifecycleState(transaction);

    }
复制代码
```
TransactionExecutor#executeLifecycleState

```Plain Text
 private void executeLifecycleState(ClientTransaction transaction) {
        final ActivityLifecycleItem lifecycleItem = transaction.getLifecycleStateRequest();
        if (lifecycleItem == null) {
            // No lifecycle request, return early.
            return;
        }

        final IBinder token = transaction.getActivityToken();
        final ActivityClientRecord r = mTransactionHandler.getActivityClient(token);
        if (DEBUG_RESOLVER) {
            Slog.d(TAG, tId(transaction) + "Resolving lifecycle state: "
                    + lifecycleItem + " for activity: "
                    + getShortActivityName(token, mTransactionHandler));
        }

        if (r == null) {
            // Ignore requests for non-existent client records for now.
            return;
        }


        //对path做循环
        //lifecycleItem.getTargetState() 为 onResume
        cycleToPath(r, lifecycleItem.getTargetState(), true /* excludeLastState */, transaction);

    }

    private void cycleToPath(ActivityClientRecord r, int finish, boolean excludeLastState,
            ClientTransaction transaction) {
        final int start = r.getLifecycleState();
        //path  = [2,3]
        final IntArray path = mHelper.getLifecyclePath(start, finish, excludeLastState);
        performLifecycleSequence(r, path, transaction);
    }




复制代码
```
getLifecyclePath 方法返回待会遍历执行生命周期的数组 ,此时返回 [2,3]

```Plain Text
//framework\base\core\java\android\app\servertransaction\TransactionExecutorHelper.java

    // public static final int UNDEFINED = -1;
    // public static final int PRE_ON_CREATE = 0;
    // public static final int ON_CREATE = 1;
    // public static final int ON_START = 2;
    // public static final int ON_RESUME = 3;
    // public static final int ON_PAUSE = 4;
    // public static final int ON_STOP = 5;
    // public static final int ON_DESTROY = 6;
    // public static final int ON_RESTART = 7;

  //  start = ON_CREATE =1 , finish = ON_RESUME =3
public IntArray getLifecyclePath(int start, int finish, boolean excludeLastState) {

        mLifecycleSequence.clear();
        if (finish >= start) {
            if (start == ON_START && finish == ON_STOP) {
                // A case when we from start to stop state soon, we don't need to go
                // through the resumed, paused state.
                mLifecycleSequence.add(ON_STOP);
            } else {
                //添加 2 和 3  即 onStart 和 onResume
                for (int i = start + 1; i <= finish; i++) {
                    mLifecycleSequence.add(i);
                }
            }
        } 

        return mLifecycleSequence;
    }
复制代码
```
TransactionExecutor#performLifecycleSequence

```Plain Text

private void performLifecycleSequence(ActivityClientRecord r, IntArray path,
            ClientTransaction transaction) {
        final int size = path.size();
        //path 为 ON_START  ON_RESUME 
        for (int i = 0, state; i < size; i++) {
            state = path.get(i);
            switch (state) {
                case ON_START:
                    //调用ActivityThread#handleStartActivity
                    mTransactionHandler.handleStartActivity(r.token, mPendingActions);
                    break;
                case ON_RESUME:
                  //调用ActivityThread#handleResumeActivity
                    mTransactionHandler.handleResumeActivity(r.token, false /* finalStateRequest */,
                            r.isForward, "LIFECYCLER_RESUME_ACTIVITY");
                    break;

            }
        }
    }
复制代码
```
ActivityThread#handleStartActivity 调用onStart 和 OnRestoreInstanceState

```Plain Text
public void handleStartActivity(ActivityClientRecord r,
            PendingTransactionActions pendingActions) {
        final Activity activity = r.activity;


        // 调用onStart
        activity.performStart("handleStartActivity");
        r.setState(ON_START);

        // 调用OnRestoreInstanceState
        if (pendingActions.shouldRestoreInstanceState()) {
            if (r.isPersistable()) {
                if (r.state != null || r.persistentState != null) {
                    mInstrumentation.callActivityOnRestoreInstanceState(activity, r.state,
                            r.persistentState);
                }
            } else if (r.state != null) {
                mInstrumentation.callActivityOnRestoreInstanceState(activity, r.state);
            }
        }

        // 调用 postOnCreate()
        if (pendingActions.shouldCallOnPostCreate()) {
            activity.mCalled = false;
            if (r.isPersistable()) {
                mInstrumentation.callActivityOnPostCreate(activity, r.state,
                        r.persistentState);
            } else {
                mInstrumentation.callActivityOnPostCreate(activity, r.state);
            }

        }
    }
复制代码
```
ActivityThread#handleResumeActivity , 调用onResume方法 然后addView开始view的绘制

```Plain Text
public void handleResumeActivity(IBinder token, boolean finalStateRequest, boolean isForward,
            String reason) {


        //执行onResume方法   
        final ActivityClientRecord r = performResumeActivity(token, finalStateRequest, reason);

        final Activity a = r.activity;

        boolean willBeVisible = !a.mStartedActivity;
        if (!willBeVisible) {
            try {
                willBeVisible = ActivityTaskManager.getService().willActivityBeVisible(
                        a.getActivityToken());
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        if (r.window == null && !a.mFinished && willBeVisible) {
            r.window = r.activity.getWindow();
            View decor = r.window.getDecorView();
            decor.setVisibility(View.INVISIBLE);
            ViewManager wm = a.getWindowManager();
            WindowManager.LayoutParams l = r.window.getAttributes();
            a.mDecor = decor;
            l.type = WindowManager.LayoutParams.TYPE_BASE_APPLICATION;
            l.softInputMode |= forwardBit;
            if (r.mPreserveWindow) {
                a.mWindowAdded = true;
                r.mPreserveWindow = false;

                ViewRootImpl impl = decor.getViewRootImpl();
                if (impl != null) {
                    impl.notifyChildRebuilt();
                }
            }
            if (a.mVisibleFromClient) {
                if (!a.mWindowAdded) {
                    a.mWindowAdded = true;
                    //执行View的绘制
                    wm.addView(decor, l);
                } else {
                    a.onWindowAttributesChanged(l);
                }
            }

        } 
        Looper.myQueue().addIdleHandler(new Idler());
    }
```
