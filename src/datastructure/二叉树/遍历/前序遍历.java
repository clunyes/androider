package datastructure.二叉树.遍历;

import java.util.LinkedList;
import java.util.List;

public class 前序遍历 {
    static List<Integer> list;
    public static void main(String[] args) {

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        list = new LinkedList<Integer>();
        loop(root);
        return list;
    }

    void loop(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            loop(root.left);
            loop(root.right);
        }
    }
}
