package algorithms.leetcode;

public class 跳跃游戏 {

    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        canJump(arr);
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
