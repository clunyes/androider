package arithmetic.test;

import java.util.Arrays;

public class testInsert {
    public static void main(String[] args) {
        int[] a = {45, 21, 32, 43, 98, 54, 45, 23, 4, 66, 86, 66,};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void insertSort(int[] array) {
        int insertNote;
        int j;
        for (int i = 1; i < array.length - 1; i++) {
            insertNote = array[i];
            j = i - 1;
            while (j >= 0 && insertNote < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertNote;
        }
    }
}
