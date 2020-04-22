package datastructure.二叉树.leetcode探索;

public class 最大深度 {
    private int answer;

    public int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        answer = Math.max(answer, depth);
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
        return answer;
    }
}
