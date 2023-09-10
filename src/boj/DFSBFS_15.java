package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSBFS_15 {

    /**
     * 5567번
     * 문제
     * 상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다.
     * 상근이의 동기는 모두 N명이고, 이 학생들의 학번은 모두 1부터 N까지이다. 상근이의 학번은 1이다.
     *
     * 상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다.
     * 이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 상근이의 동기의 수 n (2 ≤ n ≤ 500)이 주어진다.
     * 둘째 줄에는 리스트의 길이 m (1 ≤ m ≤ 10000)이 주어진다.
     * 다음 줄부터 m개 줄에는 친구 관계 ai bi가 주어진다. (1 ≤ ai < bi ≤ n) ai와 bi가 친구라는 뜻이며,
     * bi와 ai도 친구관계이다.
     *
     * 힌트
     * 예제 1의 경우 2와 3은 상근이의 친구이다. 또, 3과 4는 친구이기 때문에, 4는 상근이의 친구의 친구이다.
     * 5와 6은 친구도 아니고, 친구의 친구도 아니다. 따라서 2, 3, 4 3명의 친구를 결혼식에 초대한다.
     *
     * 출력
     * 첫째 줄에 상근이의 결혼식에 초대하는 동기의 수를 출력한다.
     *
     * 예제 입력 1
     * 6
     * 5
     * 1 2
     * 1 3
     * 3 4
     * 2 3
     * 4 5
     * 예제 출력 1
     * 3
     * 예제 입력 2
     * 6
     * 5
     * 2 3
     * 3 4
     * 4 5
     * 5 6
     * 2 5
     * 예제 출력 2
     * 0
     */

    static int[][] intarr;
    static int N;
    static int M;
    static int count = 0;

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
        int minTime = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int curNum = curNode.num;
            int curTime = curNode.time;

            for(int j=1; j<=N; j++) {
                if(check[j]==false && intarr[curNum][j]==1) {
                    check[j] = true;
                    minTime = curTime+1;
                    queue.offer(new Node(j,curTime+1));
                    if(minTime>2) break;
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        DFSBFS_15 main = new DFSBFS_15();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
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
        main.bfs(1);
    }
}
