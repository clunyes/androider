Window分为三大类型，分别是Application Window（应用程序窗口）、SubWindow（子窗口）、SystemWindow（系统窗口），
每个大类型中又包含了很多类型，都定义在Window Manager的静态内部类LayoutParams中

子窗口：PopupWindow系统窗口：Toast 输入法窗口 系统音量窗口

窗口显示次序

当一个进程向WMS申请一个窗口时，WMS会为窗口确定显示次序。为了方便窗口显示次序的管理，
手机屏幕可以虚拟地用x、y、z轴来表示，z轴垂直于屏幕，从屏幕内指向屏幕外，
这样确定窗口显示次序也就是确定窗口在z轴上的次序，这个次序称为Z-oder，type值是Z-oder排序的依据，
Type值越大则Z-oder排序越靠前，就越靠近用户