PackagerParser 用于解析磁盘上的APK安装包文件
```
a single "monolithic" APK, or apps packaged as a "cluster" of multiple
* APKs in a single directory.
```
提到两个概念：Single APK与Multiple APK，那我们就来简单解释下这两种APK
```
Single APK就是我们通常所开发的APK，即一个应用只有一个APK文件，
而Google Play 还允许你为一个应用中发布不同的APK文件，这些APK文件适用于不同的设备，
例如：你现在有一个APP叫DEMO1，但是目前由于APK的体积太大或者其他因素导致不能同时适用于手机和平板，
此时你就可以将原先的DEMO.apk，拆分为Demo_phone和Demo_tablet分别用于运行在android手机和Android平板，
只要保存两者拥有相同的包名，并用相同key进行签名就可以在发布Demo应用的时候，
一起发布Demo_phone和Demo_tablet.apk，那么这种一个应用拥有多个APK文件的程序就称为Mutiple APK。

```
大多数APK是Single APK，因此Multiple APK可以优先级放低

PackageLite
是PackageParser中的内部类，因为解析APK耗时复杂，所以需要一个轻量级过程辅助。

Package
是PackageParser中的内部类，完整的APK包信息类
