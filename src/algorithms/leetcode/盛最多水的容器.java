package algorithms.leetcode;

public class 盛最多水的容器 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
               int temp = (j - 1) * Math.min(height[i], height[j]);
               if(temp>area){
                   area = temp;
               }
            }
        }
        return area;
    }
}
