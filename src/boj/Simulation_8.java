package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Simulation_8 {

    /**
     * 14500번
     * 문제
     * 폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.
     *
     * 정사각형은 서로 겹치면 안 된다.
     * 도형은 모두 연결되어 있어야 한다.
     * 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
     * 정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.
     *
     *
     *
     * 아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다.
     * 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.
     *
     * 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.
     *
     * 테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.
     *
     * 입력
     * 첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
     *
     * 둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸,
     * 쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.
     *
     * 출력
     * 첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.
     *
     * 예제 입력 1
     * 5 5
     * 1 2 3 4 5
     * 5 4 3 2 1
     * 2 3 4 5 6
     * 6 5 4 3 2
     * 1 2 1 2 1
     * 예제 출력 1
     * 19
     * 예제 입력 2
     * 4 5
     * 1 2 3 4 5
     * 1 2 3 4 5
     * 1 2 3 4 5
     * 1 2 3 4 5
     * 예제 출력 2
     * 20
     * 예제 입력 3
     * 4 10
     * 1 2 1 2 1 2 1 2 1 2
     * 2 1 2 1 2 1 2 1 2 1
     * 1 2 1 2 1 2 1 2 1 2
     * 2 1 2 1 2 1 2 1 2 1
     * 예제 출력 3
     * 7
     */

    static int[][] intarr;
    static boolean[][] visitarr;
    static int N;
    static int M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = 0;

    public void dfs(int row, int col, int sum, int count) {
        //테트로미노 완성시 합 계산
        if(count==4) {
            answer = Math.max(answer,sum);
            return;
        }
        for (int i=0; i<4; i++) {
            int newrow = row + dx[i];
            int newcol = col + dy[i];

            //지도 넘어가는 경우
            if(newrow < 0 || newcol < 0 || newrow >=N || newcol >= M) continue;

            if(visitarr[newrow][newcol]==true) continue;

            if(count==2) {
                visitarr[newrow][newcol] = true;
                dfs(row,col,sum+intarr[newrow][newcol],count+1);
                visitarr[newrow][newcol] = false;
            }
            visitarr[newrow][newcol] = true;
            dfs(newrow, newcol,sum+intarr[newrow][newcol], count+1);
            visitarr[newrow][newcol] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        Simulation_8 main = new Simulation_8();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        visitarr = new boolean[N][M];
        intarr = new int[N][M];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                intarr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visitarr[i][j] = true;
                main.dfs(i,j,intarr[i][j],1);
                visitarr[i][j] = false;
            }
        }

        br.close();
        System.out.println(answer);
    }
}
