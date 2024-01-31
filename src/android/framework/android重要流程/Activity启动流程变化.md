发现最新的Android9.0源码中startActivity启动Activity的流程相比于低版本的Android源码来说改动较大。

- Activity启动方式

```
//startActivity
Intent intent = new Intent(ActivityA 实例, ActivityB.class);
startActivity(intent);
//startActivityForResult
startActivityForResult(intent,REQUEST_CODE);
```

- Activity启动流程分析
```
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
```

具体代码在为知笔记中