package arithmetic;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {21, 32, 43, 98, 54, 45, 23, 4, 66, 86,66,45};
        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
