package datastructure.树.二叉树遍历;

import datastructure.树.二叉树遍历.TreeNode;

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
