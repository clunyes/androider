# AIDL补充
Android SDK工具会基于AIDL生成Java语言的接口文件：

[https://www.jianshu.com/p/b5611c9b4d22](https://www.jianshu.com/p/b5611c9b4d22)  ，参考这篇文章

```Plain Text
public class RemoteService extends Service {

    private IBinder mServiceBinder = new IMyAidlInterface.Stub(){
        @Override
        public void getInformation() {
            Log.i("RemoteService","information");
        }
    };

    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mServiceBinder;
    }
}
```
```Plain Text
public class MainActivity extends AppCompatActivity {

    IMyAidlInterface myAidlInterface;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            try {
                myAidlInterface.getInformation();
            } catch (RemoteException ex) {
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startAndBindService();
    }

    private void startAndBindService() {
        Intent serviceIntent = new Intent(MainActivity.this, RemoteService.class);
        bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE);
    }
}
```


```Plain Text
public interface IMyAidlInterface extends android.os.IInterface
{
    public static abstract class Stub extends android.os.Binder implements com.example.testapplication.IMyAidlInterface
    {
        private static final java.lang.String DESCRIPTOR = "com.example.testapplication.IMyAidlInterface";
        public Stub()
        {
            this.attachInterface(this, DESCRIPTOR);
        }
        
        public static com.example.testapplication.IMyAidlInterface asInterface(android.os.IBinder obj)
        {
            if ((obj==null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin!=null)&&(iin instanceof com.example.testapplication.IMyAidlInterface))) {
                return ((com.example.testapplication.IMyAidlInterface)iin);
            }
            return new com.example.testapplication.IMyAidlInterface.Stub.Proxy(obj);
        }
        @Override public android.os.IBinder asBinder()
        {
            return this;
        }
        @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
        {
            switch (code)
            {
                case INTERFACE_TRANSACTION:
                {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_getInformation:
                {
                    data.enforceInterface(DESCRIPTOR);
                    this.getInformation();
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
        private static class Proxy implements com.example.testapplication.IMyAidlInterface
        {
            private android.os.IBinder mRemote;
            Proxy(android.os.IBinder remote)
            {
                mRemote = remote;
            }
            @Override public android.os.IBinder asBinder()
            {
                return mRemote;
            }
            public java.lang.String getInterfaceDescriptor()
            {
                return DESCRIPTOR;
            }
            @Override public void getInformation() throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getInformation, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
        static final int TRANSACTION_getInformation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }
    public void getInformation() throws android.os.RemoteException;
}
```




我们声明的接口IMyAidlInterface包含了一个静态内部类Stub，并且Stub也继承了IMyAidlInterface，所以Stub是IMyAidlInterface的具体实现，而Stub又是一个抽象类，最终的实现在RemoteService中
Stub内部包含了一个静态内部类Proxy，同样实现了接口IMyAidlInterface
可以通过前面的例子梳理一下Stub-proxy的工作流程

* RemoteService中的IBinder对象mServiceBinder是Stub的具体实现，在RemoteService和activity绑定的时候被返回
* 被返回的mServiceBinder最终是作为onServiceConnected中的参数，
* Activity端会调用Stub中的静态方法asInterface，mServiceBinder作为参数，最后拿到IMyAidlInterface接口对象myAidlInterface

在asInterface方法中首先会判断Binder是否处在当前进程，否则构造Proxy并返回，构造Proxy时，把mServiceBinder赋值给mRemote，Proxy中实现的接口getInformation会调用mRemote的transact方法，而Binder的通信是靠transact和onTransact实现的，最后会走到Stub的onTransact，完成对mServiceBinder的调用

