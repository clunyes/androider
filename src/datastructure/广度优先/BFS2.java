package datastructure.广度优先;

public class BFS2 {
//    有时，确保我们永远不会访问一个结点两次很重要。
//    Queue<Node> queue;  // store all nodes which are waiting to be processed
//    Set<Node> used;     // store all the used nodes
//    int step = 0;       // number of steps neeeded from root to current node
//    // initialize
//    add root to queue;
//    add root to used;
//    // BFS
//    while (queue is not empty) {
//        step = step + 1;
//        // iterate the nodes which are already in the queue
//        int size = queue.size();
//        for (int i = 0; i < size; ++i) {
//            Node cur = the first node in queue;
//            return step if cur is target;
//            for (Node next : the neighbors of cur) {
//                if (next is not in used) {
//                    add next to queue;
//                    add next to used;
//                }
//            }
//            remove the first node from queue;
//        }
//    }
//    return -1;          // there is no path from root to target
}
