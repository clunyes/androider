#### 开始阶段（BOOT_PROGRESS_PMS_START）
1. 关键对象初始化，并赋值

#### 扫描系统阶段 （BOOT_PROGRESS_PMS_SYSTEM_SCAN_START） 
1. 创建system子目录
2. 扫描系统文件vendor/overlay system/framework system/app等
3. 对扫描到的文件，进行后序处理（更新或者不更新）

#### 扫描Data分区阶段（BOOT_PROGRESS_PMS_DATA_SCAN_START）
1. 扫描data/app data/app-private目录
2. 扫描残留app包清除
3. 扫描mExpectingBetter，更新对应包数据

#### 扫描结束阶段（BOOT_PROGRESS_PMS_SCAN_END）
1. 当前SDK版本与上次启动SDK版本不同，重新对APK授权
2. OTA后，清除缓存
3. Settings内容保存到packages.xml文件中

#### 准备阶段（BOOT_PROGRESS_PMS_READY）
1. 启动PackageInstallerService，管理安装会话的服务，为每次安装过程分配sessionid。