package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSBFS_7 {

    /**
     * 7569 번
     * 문제
     * 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.
     * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,
     * 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
     * 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다.
     * 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
     * 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
     *
     * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
     * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
     *
     * 입력
     * 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다.
     * M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다.
     * 둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다.
     * 즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다. 각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다.
     * 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 이러한 N개의 줄이 H번 반복하여 주어진다.
     *
     * 토마토가 하나 이상 있는 경우만 입력으로 주어진다.
     *
     * 출력
     * 여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다.
     * 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
     *
     * 예제 입력 1
     * 5 3 1
     * 0 -1 0 0 0
     * -1 -1 0 1 1
     * 0 0 0 1 1
     * 예제 출력 1
     * -1
     * 예제 입력 2
     * 5 3 2
     * 0 0 0 0 0
     * 0 0 0 0 0
     * 0 0 0 0 0
     * 0 0 0 0 0
     * 0 0 1 0 0
     * 0 0 0 0 0
     * 예제 출력 2
     * 4
     * 예제 입력 3
     * 4 3 2
     * 1 1 1 1
     * 1 1 1 1
     * 1 1 1 1
     * 1 1 1 1
     * -1 -1 -1 -1
     * 1 1 1 -1
     * 예제 출력 3
     * 0
     */

    static int[][][] startarr;
    static int[][][] intarr;
    static boolean[][][] check;
    static int N;
    static int M;
    static int H;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    static class Node {
        int row;
        int col;
        int height;
        int time;

        public Node(int row, int col, int height, int time) {
            this.row = row;
            this.col = col;
            this.height = height;
            this.time = time;
        }
    }

    public int bfs(ArrayList<Node> list) {

        Queue<Node> queue = new LinkedList<>();
        list.stream().forEach(i->queue.offer(i));
        list.stream().forEach(i->check[i.row][i.col][i.height] = true);

        int minTime = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            //상하좌우위아래 순서로 이동
            for(int j=0; j<6; j++) {
                int curRow = curNode.row + dx[j];
                int curCol = curNode.col + dy[j];
                int curHeight = curNode.height + dh[j];
                int curTime = curNode.time;

                //범위 초과시 패스
                if(curRow<1 || curRow>N || curCol<1 || curCol>M || curHeight<1 || curHeight>H) continue;

                //방문한 곳이면 패스
                if(check[curRow][curCol][curHeight]==true) continue;

                //토마토가 없는 칸일때 패스
                if(intarr[curRow][curCol][curHeight]==-1) continue;

                //토마토가 익은 칸일때 패스
                if(intarr[curRow][curCol][curHeight]==1) continue;

                //토마토가 안익은 칸일때
                if(intarr[curRow][curCol][curHeight]==0) {
                    check[curRow][curCol][curHeight] = true;
                    minTime = curTime+1;
                    queue.offer(new Node(curRow,curCol,curHeight,curTime+1));
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                for(int k=1; k<=H; k++) {
                    if(intarr[i][j][k]==0 && check[i][j][k]==false) {
                        minTime = -1;
                        break;
                    }
                }
            }
        }
        return minTime;
    }

    public static void main(String[] args) throws IOException {
        DFSBFS_7 main = new DFSBFS_7();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        //col
        M = Integer.parseInt(st1.nextToken());

        //row
        N = Integer.parseInt(st1.nextToken());

        //height
        H = Integer.parseInt(st1.nextToken());

        //인접행렬 구현
        intarr = new int[N+1][M+1][H+1];
        check = new boolean[N+1][M+1][H+1];
        startarr = new int[N+1][M+1][H+1];

        ArrayList<Node> list = new ArrayList<>();

        for(int k=1; k<=H;k++) {
            for(int i=1; i<=N;i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for(int j=1; j<=M;j++) {
                    intarr[i][j][k] = Integer.parseInt(st2.nextToken());
                    if(intarr[i][j][k]==1) {
                        list.add(new Node(i,j,k,0));
                    }
                }
            }
        }
        System.out.println(main.bfs(list));
    }
}
