package datastructure.二叉树.leetcode探索;

import java.util.LinkedList;
import java.util.List;

public class 路径总和 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }

    }

    public static void main(String[] args) {

    }


}
