package datastructure.数组;

public class _queue {
    String[] a; //对象数组，队列最多存储a.length-1个对象
    int front;  //队首下标
    int rear;   //队尾下标


    public _queue(int size) {
        a = new String[size];
        front = 0;
        rear = 0;
    }

    /**
     * 将一个对象追加到队列尾部
     *
     * @param obj 对象
     * @return 队列满时返回false, 否则返回true
     */
    public boolean enqueue(String str) {
        if ((rear + 1) % a.length == front) {
            return false;
        }
        a[rear] = str;
        rear = (rear + 1) % a.length;
        return true;
    }

    /**
     * 队列头部的第一个对象出队
     *
     * @return 出队的对象，队列空时返回null
     */
    public String dequeue() {
        if (rear == front) {
            return null;
        }
        String str = a[front];
        front = (front + 1) % a.length;
        return str;
    }

    public static void main(String[] args) {
        _queue q = new _queue(4);
        System.out.println(q.enqueue("张三"));
        System.out.println(q.enqueue("李斯"));
        System.out.println(q.enqueue("赵五"));
        System.out.println(q.enqueue("王一"));//无法入队列，队列满
        for (int i = 0; i < 4; i++) {
            System.out.println(q.dequeue());
        }
    }
}
