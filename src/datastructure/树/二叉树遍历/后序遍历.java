package datastructure.树.二叉树遍历;

import java.util.LinkedList;
import java.util.List;

public class 后序遍历 {
    static List<Integer> list;
    public static void main(String[] args) {

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        list = new LinkedList<Integer>();
        loop(root);
        return list;
    }

    void loop(TreeNode root) {
        if (root != null) {
            loop(root.left);
            loop(root.right);
            list.add(root.val);
        }
    }
}
