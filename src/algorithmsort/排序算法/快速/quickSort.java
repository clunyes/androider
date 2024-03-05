package algorithmsort.排序算法.快速;

import java.util.Arrays;

public class quickSort {
    private static int times = 0;

    public static void main(String[] args) {
        int[] a = {21, 32, 43, 98, 54, 45, 23, 4, 66, 86, 66, 45};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        //1,找到递归算法的出口
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        //待排序的第一个元素作为基准值
        int key = arr[low];
        //4，完成一趟排序
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }
            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }
            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //5, 对key左边的数快排
        quickSort(arr, low, left - 1);
        //6, 对key右边的数快排
        quickSort(arr, right + 1, high);
    }
}
