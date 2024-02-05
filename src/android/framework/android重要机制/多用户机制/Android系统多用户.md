直到Android 6.0，Android多用户才比较完善，国内外的厂家也纷纷开始针对多用户这个噱头来做各种 “花里胡哨” 的操作，
“手机分身”、“分身应用”、“应用双开” 应运而生，不得不说，国内的厂家在多用户这方面定制化到如今已经非常稳定和完善了。

Android设计多用户的目的

通过分离用户帐号和应用数据，Android 支持在一台 Android 设备上添加多个用户。
例如，父母可能会允许他们的孩子使用家庭平板电脑，一个家庭可以共用一辆汽车，或者应急响应团队可能会共用一台移动设备用于呼叫值班。

### 基础概念
要学习多用户，首先我们需要了解一些基础概念：（Gid 和 Gids用处不大）
1. Uid（用户Id）：在Linux上，一个用户Uid标识着一个给定的用户。
Android上也沿用了Linux用户的概念，Root用户Uid为0，System Uid为1000，并且，
每个应用程序在安装时也被赋予了单独的Uid，这个Uid将伴随着应用从安装到卸载。
2. Gid（用户组Id）：Linux上规定每个应用都应该有一个用户组，对于Android应用程序来说，每个应用的所属用户组与Uid相同。
3. Gids：应用在安装后所获得权限的Id集合。在Android上，每个权限都可能对应一个或多个group，
每个group有个gid name，gids就是通过对每个gid name计算得出的id集合，一个UID可以关联GIDS，表明该UID拥有多种权限。

### 多用户的特性
1. 独立的userId
Android在创建每个用户时，都会分配一个整型的userId。
对于主用户（正常下的默认用户）来说，userId为0，之后创建的userId将从10开始计算，每增加一个userId加1：
启动和切换到该用户：
```
root@virgo:/ # am start-user 11
Success: user started
root@virgo:/ # am switch-user 11
```
2. 独立的文件存储
   不管是外部存储（External Storage）还是app data目录，Android都为其准备了独立的文件存储。
3. 独立的权限控制
   不同用户下App的应用权限是独立的
4. App安装的唯一性
多用户下的应用其实只安装一次，不同用户下同一个应用的版本和签名都应该相同，
不同用户下相同App能够独立运行是因为系统为他们创造了不同的运行环境和权限。

### 多用户的真面目
多用户其实是系统为应用的data目录和storage目录分配了一份不同且独立的存储空间，
不同用户下的存储空间互不影响且没有权限访问。
同时，系统中的AMS、PMS、WMS等各大服务都会针对userId/UserHandle进行多用户适配，
并在用户启动、切换、停止、删除等生命周期时做出相应策略的改变。
通过以上两点，Android创造出来一个虚拟的多用户运行环境。

### 多用户下的四大组件和数据共享
1. 跨用户启动Activity
Activity/Context提供了startActivityAsUser() 方法，
可以传入对应用户的UserHandle来达到跨用户启动Activity的目的，
只有具有"android.Manifest.permission.INTERACT_ACROSS_USERS_FULL"的系统应用才可以调用该方法
2. 跨用户启动Service
Context中提供了startServiceAsUser() 方法，经过反射测试，也是跨不过AMS的权限检查
3. 跨用户发送广播
Context中提供了sendBroadcastAsUser() 方法，但与Activity 和 Service 相同，反射调用也会抛出异常
4. 跨用户Query
系统没有提供类似getContentResolverAsUser的方法，但ContentResolver提供了跨用户query的能力。
ContentProvider中提供了hide 的 maybeAddUserId() 方法，被query的Uri中可以携带userId，AMS还是会检查权限
