package datastructure.树.二叉树遍历;

import java.util.LinkedList;
import java.util.List;

public class 中序遍历 {
    List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new LinkedList<Integer>();
        loop(root);
        return list;
    }

    void loop(TreeNode root) {
        if (root != null) {
            loop(root.left);
            list.add(root.val);
            loop(root.right);
        }
    }
}
