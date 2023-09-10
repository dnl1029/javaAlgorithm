package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7_2 {

    /**
     * BFS : 큐, DFS : 스택
     * 송아지 찾기(BFS : 상태트리 탐색)
     * 스카이 콩콩 타는데, 앞으로 1, 뒤로 1, 앞으로 5 이동할수있고
     * 현수가 송아지한테 갈수있는 최소횟수(최단거리)를 구함
     * 직선의 좌표점은 10000까지 있음
     *
     * 왼쪽입력이 현수, 오른쪾이 송아지 좌표
     * 입력 5 14
     * 출력 3
     *
     *    5   (LEVEL 0)
     *  6  4  10 (LEVEL 1)
     *7 5(생략) 11 (LEVEL 2)...
     * BFS는 레벨을 써야함.
     */

    public int BFS(int N, int M) {
//        int answer = 0;
        int[] check = new int[10001];
        int[] dis = {1, -1, 5};
        Queue<Integer> queue = new LinkedList<>();
        check[N] = 1;
        queue.offer(N);

        int level = 0;
        while (!queue.isEmpty()) {
            //len을 선언해놔야지 안그러면 도중에 queue사이즈가 바뀜..
            int len = queue.size();
            for(int i=0; i<len; i++) {
                int x = queue.poll().intValue();
                for(int j=0; j<3; j++) {
                    int newX = x+dis[j];
                    if(newX==M) {
                        return level+1;
                    }
                    if(newX>=1 && newX<=10000 && check[newX]==0) {
                        check[newX]=1;
                        queue.offer(newX);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Q7_2 main = new Q7_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        br.close();
        System.out.println(main.BFS(N,M));
    }
}
