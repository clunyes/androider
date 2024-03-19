Flow可以理解为生产数据流，不是一个数据，而是一串数据。
热流的实现StateFlow，SharedFlow，它们允许数据流以最优方式，发出状态更新并向多个使用方发出值。

StateFlow是一个状态容器式可观察数据流，可以向其收集器发出当前状态更新和新状态更新，
任何对值的更新都会反馈新值到所有流的接收器中。还可通过其value属性读取当前状态值。

flow每发射一个数据，在collect按顺序处理，处理完一个才会处理下一个。


```
fun makeFlow() = flow {
   println("sending first value")
   emit(1)
   println("first value collected, sending another value")
   emit(2)
   println("second value collected, sending a third value")
   emit(3)
   println("done")
}

scope.launch {
   makeFlow().collect { value ->
       println("got $value")
   }
   println("flow is completed")
}
```
运行上面的代码会输出以下内容：
```
sending first value
got 1
first value collected, sending another value
got 2
second value collected, sending a third value
got 3
done
flow is completed
```

每次 flow 构建器调用 emit 时，它都会 suspends，直到元素完全处理为止。当从 flow 中请求另一个值时，
它会从上次停止的位置 resumes，直到它再次调用 emit。flow 构建器完成后，Flow 将被取消，
同时 collect 恢复，从而允许调用协程输出“flow is completed”。