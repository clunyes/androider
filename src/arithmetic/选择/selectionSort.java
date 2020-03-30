package arithmetic.选择;

import java.util.Arrays;

public class selectionSort {
    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int k = i;
            // 找出最小值的小标
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[k]) {
                    k = j;
                }
            }
            // 将最小值放到排序序列末尾
            if (k > i) {
                int tmp = a[i];
                a[i] = a[k];
                a[k] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] b = { 21, 32, 43, 98, 54, 45, 23, 4, 66, 86,66,45 };
        selectionSort(b);
        System.out.println(Arrays.toString(b));
    }
}
