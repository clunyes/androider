package datastructure.二叉树.leetcode探索;

public class 从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        buildTree(pre, in);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public static TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int currentVal = preorder[preStart];
        TreeNode current = new TreeNode(currentVal);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == currentVal) {
                inIndex = i;
            }
        }
        TreeNode left = helper(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        TreeNode right = helper(preorder, inorder, preStart + (inIndex - inStart) + 1, inIndex + 1, inEnd);
        current.left = left;
        current.right = right;
        return current;
    }
}
