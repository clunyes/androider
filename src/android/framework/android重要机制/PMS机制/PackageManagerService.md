与ActivityManager和AMS关系类似，PMS也有对应管理类PackageManager。
PackageManager是抽象类，实现类是ApplicationPackageManager。
PMS主要提供以下功能
1. 获取一个应用程序的所有信息（ApplicationInfo）
2. 获取四大组件信息
3. 查询permission相关信息
4. 获取包信息
5. 安装、卸载APK