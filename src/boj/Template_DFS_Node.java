package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Template_DFS_Node {

    /**
     *
     */

    static int[][] intarr;
    static boolean[][] check;
    static int N;
    static int M;
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


    public int dfs(int row, int col, int time) {

        Stack<Node> stack = new Stack<>();
        check[row][col] = true;
        stack.push(new Node(row, col, time));

        int minTime = 0;
        while (!stack.isEmpty()) {
            Node curNode = stack.peek();

            boolean flag = false;
            //상하좌우 순서로 이동
            for(int j=0; j<4; j++) {
                int curRow = curNode.row + dx[j];
                int curCol = curNode.col + dy[j];
                int curTime = curNode.time;

                //범위 초과시 패스
                if(curRow<1 || curRow>N || curCol<1 || curCol>M) continue;

                //방문한 곳이면 패스
                if(check[curRow][curCol]==true) continue;

                //특정 값일때 패스
                if(intarr[curRow][curCol]==-1) continue;

                //이동할 수 있는 조건
                if(intarr[curRow][curCol]==0) {
                    check[curRow][curCol] = true;
                    minTime = curTime+1;
                    stack.push(new Node(curRow,curCol,curTime+1));
                    flag = true;
                }
            }
            if(!flag) {
                stack.pop();
            }
        }
        return minTime;
    }

    public static void main(String[] args) throws IOException {
        Template_DFS_Node main = new Template_DFS_Node();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        //row
        N = Integer.parseInt(st1.nextToken());

        //col
        M = Integer.parseInt(st1.nextToken());
        //인접행렬 구현
        intarr = new int[N+1][M+1];
        check = new boolean[N+1][M+1];


        for(int i=1; i<=N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                intarr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        System.out.println(main.dfs(4,6,0));
    }
}
