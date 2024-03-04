# ActivityRecord
```Plain Text
An entry in the history stack, representing an activity.
```
用于描述一个activity

ActivityRecord是system_server进程中的对象，ActivityClientRecord和Activity都是App进程中的对象

ActivityRecord 的部分重要的成员变量如下表所示

|名称|类型|说明|
| ----- | ----- | ----- |
|service|ActivityManagerService|AMS 的引用|
|info|ActivityInfo|Activity中代码和AndroidManifest设置的节点信息，比如 launchMode|
|launchedFromPackage|String|启动 Activity 的包名|
|taskAffinity|String|Activity 希望归属的栈|
|task|TaskRecord|ActivityRecord 所在的 TaskRecord|
|app|ProcessRecord|ActivityRecord 所在的应用程序进程|
|state|ActivityState|当前 Activity 的状态|
|icon|int|Activity 的图标资源标识符|
|theme|int|Activity 的主题资源标识符|

