package datastructure.二叉树.遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 对称二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        left1.right = new TreeNode(3);
        TreeNode right1 = new TreeNode(2);
        right1.right = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        isSymmetric(root);
    }

    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        TreeNode cur;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subAns = new LinkedList<Integer>();
            for (int i = 0; i < size; ++i) {
                cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                    subAns.add(cur.left.val);
                } else {
                    subAns.add(-1);
                }
                if (cur.right != null) {
                    q.offer(cur.right);             // push right child to queue if it is not null
                    subAns.add(cur.right.val);
                } else {
                    subAns.add(-1);
                }
            }
            if (subAns.size() % 2 == 1) {
                return false;
            }
            for (int i = 0; i < subAns.size() / 2; i++) {
                if (subAns.get(i) != subAns.get(subAns.size() - i - 1)) {
                    return false;
                }
            }

        }
        return true;
    }
}
