package datastructure.二叉树.leetcode探索;

/**
 * //1、在后序遍历序列中,最后一个元素为树的根节点
 * 	//2、在中序遍历序列中,根节点的左边为左子树，根节点的右边为右子树
 * 	//不断将数组划分为左子树、根、右子树，大小为1的子树即为叶节点
 * 	//中序数组：根节点ri, 左子树数组in_lo~ri-1, 右子树数组，ri+1~in_hi
 * 	//后序数组：根节点post_hi,左子树数组post_lo~post_lo-in_lo+ri-1，右子树数组post_lo-in_lo+ri~post_hi-1
 */
public class 从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int currentVal = postorder[postEnd];
        TreeNode current = new TreeNode(currentVal);

        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == currentVal) {
                inIndex = i;
            }
        }
        TreeNode left = helper(inorder, postorder, postEnd - (inEnd- inIndex) - 1, inStart, inIndex - 1);
        TreeNode right = helper(inorder, postorder, postEnd - 1, inIndex + 1, inEnd);
        current.left = left;
        current.right = right;
        return current;
    }
}
