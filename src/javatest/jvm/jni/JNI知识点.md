# JNI知识点
Navtive方法的注册将Java中的Native方法通过方法指针与JNI进行关联。

##### 静态注册
通过javac命令编译和javah命令生成JNI方法的.h文件，方法首次调用时进行关联，即保存JNI的函数指针

##### 动态注册 
用JNINativeMethod数据结构记录Java中的Native方法和JNI方法的关联，
在调用System.loadLibrary()方法后，会查找加载的so库中的JNI_OnLoad方法，
如果存在则调用该方法，其最终调用JNIEnv的RegisterNatives方法来完成动态注册。

##### 基本数据转换
|<br>**Java**|**Native**|**签名**|
| ----- | ----- | ----- |
|byte|jbyte|B|
|char|jchar|C|
|short|jshort|S|
|int|jint|I|
|float|jfloat|F|
|double|jdouble|D|
|long|jlong|J|
|boolean|jboolean|Z|
|void|void|V|



##### 引用数据转换
|**Java**|**Native**|**签名**|
| ----- | ----- | ----- |
|所有对象		|jobject|L+classname +;|
|Class|jclass|Ljava/lang/Class;|
|String|jstring|Ljava/lang/String;|
|Throwable|jthrowable|Ljava/lang/Throwable;|
|Object[]|jthrowable|[L+classname +;|
|byte[]|jbyteArray|[B|
|char[]|jcharArray|[C|
|double[]|jdoubleArray|[D|
|float[]|jfloatArray|[F|
|int[]		|jintArray|[I|
|short[]		|jshortArray|[S|
|long[]		|jlongArray|[J|
|boolean[]		|jbooleanArray|[Z|





