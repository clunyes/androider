postValue 与 setValue 一样都是用来更新 LiveData 数据的方法：

setValue 只能在主线程调用，同步更新数据
postValue 可在后台线程调用，其内部会切换到主线程调用 setValue

当连续调用 postValue 时，只会收到最后一次数据更新通知。
    
postValue 将数据存入后，会再没有被消费前post一个Runnable。
而在，再次post后不会重新post Runnable了，只会修改里面的数据mPendingData。