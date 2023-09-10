package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Template_BFS_Node_Integer_Time {

    /**
     *
     */

    static int[][] intarr;
    static int N;
    static int M;
    static int start;
    static int target;

    //최단거리 기록하려면 node 사용
    static class Node {
        int num;
        int time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }


    public void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] check = new boolean[N+1];
        check[start] = true;
        queue.offer(new Node(start,0));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        int minTime = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int curNum = curNode.num;
            int curTime = curNode.time;

            if(check[target]==true) break;

            for(int j=1; j<=N; j++) {
                if(check[j]==false && intarr[curNum][j] ==1) {
                    check[j] = true;
                    minTime = curTime+1;
                    queue.offer(new Node(j,curTime+1));
                    list.add(j);
                }
            }
        }

        if(!list.contains(target)) {
            minTime = -1;
        }
        System.out.println(minTime);
    }

    public static void main(String[] args) throws IOException {
        Template_BFS_Node_Integer_Time main = new Template_BFS_Node_Integer_Time();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st1.nextToken());
        target = Integer.parseInt(st1.nextToken());

        M = Integer.parseInt(br.readLine());

        //인접행렬 구현
        intarr = new int[N+1][N+1];

        for(int i=1; i<=M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            intarr[a][b] = 1;
            intarr[b][a] = 1;
        }
        br.close();
        main.bfs(start);
    }
}
