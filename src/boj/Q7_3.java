package boj;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Q7_3 {

    /**
     * tree 말단 노드까지의 가장 짧은 경로
     */

    public static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    Node root;
    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int Level = 0;
        while(!Q.isEmpty()) {
            int len=Q.size();
            for(int i=0; i<len; i++) {
                Node cur = Q.poll();
                // 말단노드
                if(cur.lt == null && cur.rt == null) {
                    return Level;
                }
                if(cur.lt != null) {
                    Q.offer(cur.lt);
                }
                if(cur.rt !=null) {
                    Q.offer(cur.rt);
                }
            }
            Level ++;
        }
        // 여기까지 안옴
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Q7_3 tree = new Q7_3();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }
}
