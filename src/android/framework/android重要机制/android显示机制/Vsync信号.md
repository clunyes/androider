# Vsync信号
App 和 SurfaceFlinger 的第一个交互点就是 Vsync 信号的请求和接收，
如上图中第一条标识，Vsync-App 信号到达，就是指的是 SurfaceFlinger 的 Vsync-App 信号。
应用收到这个信号后，开始一帧的渲染准备



这部分结合[BufferQueue介绍]看。

### **RenderThread 的 dequeueBuffer**
dequeue 有出队的意思，dequeueBuffer 顾名思义，就是从队列中拿出一个 Buffer，这个队列就是 SurfaceFlinger 中的 BufferQueue。

### **RenderThread 的 queueBuffer**
queue 有入队的意思，queueBuffer 顾名思义就是讲 Buffer 放回到 BufferQueue

