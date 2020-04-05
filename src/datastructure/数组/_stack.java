package datastructure.数组;

public class _stack {
    /**
     * 数组实现栈
     */
    String[] arrays;
    int i = 0;

    public _stack(int n) {
        arrays = new String[n];
    }

    public void push(String item) {
        if (i > arrays.length - 1) {
            return;
        }
        arrays[i] = item;
        i++;
    }

    public String pop() {
        if (i > 0) {
            i--;
        }
        String temp = arrays[i];
        arrays[i] = null;
        return temp;
    }
}
