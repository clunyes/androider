package algorithms.leetcode;

public class 寻找两个有序数组的中位数 {

    public static void main(String[] args) {
        int[] arr1 = {1, 9};
        int[] arr2 = {2, 3};
        findMedianSortedArrays(arr1, arr2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newarr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int count = 0;
        while (count < newarr.length) {
            if (i >= nums1.length) {
                newarr[count] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                newarr[count] = nums1[i];
                i++;
            } else {
                if (nums1[i] < nums2[j]) {
                    newarr[count] = nums1[i];
                    i++;
                } else {
                    newarr[count] = nums2[j];
                    j++;
                }
            }
            count++;
        }
        if (newarr.length % 2 == 0) {
            return Double.valueOf(newarr[newarr.length / 2 - 1] + newarr[newarr.length / 2]) / 2;
        } else {
            return newarr[newarr.length / 2];
        }

    }
}
