package arithmetic.test;

import java.util.Arrays;

public class TestQuick {
    public static void main(String[] args) {
        int[] array = {25, 89, 8, 15, 47, 88, 22, 36, 65, 44};
//        int[] array = {0,1,2,3,4,5,6,7,8,9};
        quickSort(array, 0, array.length - 1);
        System.out.print(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int key = array[low];
        while (i < j) {
            while (i < j && array[j] > key) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= key) {
                i++;
            }
            array[j] = array[i];

        }
        array[i] = key;
        quickSort(array, 0, i - 1);
        quickSort(array, i + 1, high);
    }

}
