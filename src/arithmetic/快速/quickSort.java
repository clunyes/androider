package arithmetic.快速;

import java.util.Arrays;

public class quickSort {
    private static int times = 0;

    public static void main(String[] args) {
        int[] a = {21, 32, 43, 98, 54, 45, 23, 4, 66, 86,66,45};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if (low > high) {
            return;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[low];
        //4，完成一趟排序
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= key)
                j--;
//            if (i < j)
                a[i] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < key)
                i++;
//            if (i < j) // 用比基准大的记录替换高位记录
                a[j] = a[i];
        }
        a[i] = key;// 将基准数值替换回 a[i]
        //5, 对key左边的数快排
        quickSort(a, low, i - 1);
        //6, 对key右边的数快排
        quickSort(a, i + 1, high);
    }
}
