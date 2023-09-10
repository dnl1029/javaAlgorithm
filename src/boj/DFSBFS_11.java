package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFSBFS_11 {

    /**
     * 2667번
     * 문제
     * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
     * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
     * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
     * 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
     * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

     * 입력
     * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
     *
     * 출력
     * 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
     *
     * 예제 입력 1
     * 7
     * 0110100
     * 0110101
     * 1110101
     * 0000111
     * 0100000
     * 0111110
     * 0111000
     * 예제 출력 1
     * 3
     * 7
     * 8
     * 9
     */

    static int[][] intarr;
    static boolean[][] check;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int row;
        int col;
        int time;

        public Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }


    public int bfs(int row, int col, int time) {

        Queue<Node> queue = new LinkedList<>();
        check[row][col] = true;
        queue.offer(new Node(row, col, time));

        int count = 1;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            //상하좌우 순서로 이동
            for(int j=0; j<4; j++) {
                int curRow = curNode.row + dx[j];
                int curCol = curNode.col + dy[j];
                int curTime = curNode.time;

                //범위 초과시 패스
                if(curRow<1 || curRow>N || curCol<1 || curCol>N) continue;

                //방문한 곳이면 패스
                if(check[curRow][curCol]==true) continue;

                //0일때 패스
                if(intarr[curRow][curCol]==0) continue;

                //이동할 수 있는 조건(1일때)
                if(intarr[curRow][curCol]==1) {
                    check[curRow][curCol] = true;
                    count++;
                    queue.offer(new Node(curRow,curCol,curTime+1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        DFSBFS_11 main = new DFSBFS_11();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        //인접행렬 구현
        intarr = new int[N+1][N+1];
        check = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++) {
            String[] split = br.readLine().split("");
            for(int j=1;j<=N;j++) {
                intarr[i][j] = Integer.parseInt(split[j-1]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=N;i++) {
            for(int j=1; j<=N;j++) {
                if(intarr[i][j]==1 && check[i][j]==false) {
                    int count = main.bfs(i,j,1);
                    list.add(count);
                }
            }
        }
        System.out.println(list.size());
        list.stream().sorted().forEach(i-> System.out.println(i));
    }
}
