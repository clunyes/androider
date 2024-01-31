scheme跳转协议

```
<activity android:name="com.scc.demo.actvitiy.RedActivity"
   >
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <data
            android:host="scc"
            android:path="/redActivity"
            android:port="2021"
            android:scheme="sccdemo" />
    </intent-filter>
</activity>

<a href="sccdemo://scc:2021/redActivity?color=0000&ad=10086">打开源生应用指定的RedActivity</a>
```