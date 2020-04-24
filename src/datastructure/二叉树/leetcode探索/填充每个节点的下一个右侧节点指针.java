package datastructure.二叉树.leetcode探索;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针 {

    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) return null;
        Node begin = root;
        Node end = root;
        Node current = root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node x = queue.poll();
            if (x == begin) {//如果当前节点是该层第一个节点，begin更新为下
                //一层的第一个节点，current = x
                begin = x.left;
                current = x;
            } else {//如果不是第一个节点，x就会被current.next指向
                current.next = x;
                current = current.next;//current跟进
            }
            if (x == end) {//如果x是最后一个节点，那么end更新为下一层的最后一个节点
                end = x.right;
            }
            //下一层入队
            if (x.left != null) {
                queue.offer(x.left);
            }
            if (x.right != null) {
                queue.offer(x.right);
            }
        }
        return root;
    }
}
