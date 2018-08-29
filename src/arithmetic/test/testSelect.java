package arithmetic.test;

import java.util.Arrays;

public class testSelect {

    public static void main(String[] args) {
        int[] a = {45, 21, 32, 43, 98, 54, 45, 23, 4, 66, 86, 66,};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int k = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    k = j;
                }
            }
            if (k > i) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
    }
}
