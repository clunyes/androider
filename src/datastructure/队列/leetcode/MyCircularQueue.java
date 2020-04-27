package datastructure.队列.leetcode;

public class MyCircularQueue {
    private int[] array;
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        array = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    //判断是否能插入成功，插变rear
    public boolean enQueue(int value) {
        //如果已满，不能在插入了
        if (array.length == size) {
            return false;
        }
        array[rear] = value;
        rear = (rear + 1) % array.length;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    //判断能否删除成功，删除变front
    public boolean deQueue() {
        //如果为空，不能删了
        if (size == 0) {
            return false;
        }
        front = (front + 1) % array.length;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0) {
            return -1;
        }
        return array[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) {
            return -1;
        }
        int index = (rear - 1 + array.length) % array.length;
        return array[index];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == array.length;
    }
}
