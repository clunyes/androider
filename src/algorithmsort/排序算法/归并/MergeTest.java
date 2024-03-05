package algorithmsort.排序算法.归并;

public class MergeTest {
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L) / 2;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int helpi = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[helpi++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[helpi++] = arr[p1++];
        }
        while (p2 <= R) {
            help[helpi++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 1, 2, 4, 5};
        process(arr, 0, 6);
    }
}
