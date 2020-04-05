package datastructure.图;

import java.util.ArrayList;

public class Node {
    public int value;
    public int in;//入度（指向该节点的线条数目）
    public int out;//出度（从该节点指出的线条数目）
    public ArrayList<Node> nexts;//下一级节点
    public ArrayList<Edge> edges;//边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
