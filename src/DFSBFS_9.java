import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFSBFS_9 {

    /**
     * 2178번
     * 문제
     * N×M크기의 배열로 표현되는 미로가 있다.
     *
     * 1	0	1	1	1	1
     * 1	0	1	0	1	0
     * 1	0	1	0	1	1
     * 1	1	1	0	1	1
     * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
     * 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
     * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
     *
     * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
     *
     * 입력
     * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
     *
     * 출력
     * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
     *
     * 예제 입력 1
     * 4 6
     * 101111
     * 101010
     * 101011
     * 111011
     * 예제 출력 1
     * 15
     * 예제 입력 2
     * 4 6
     * 110110
     * 110110
     * 111111
     * 111101
     * 예제 출력 2
     * 9
     * 예제 입력 3
     * 2 25
     * 1011101110111011101110111
     * 1110111011101110111011101
     * 예제 출력 3
     * 38
     * 예제 입력 4
     * 7 7
     * 1011111
     * 1110001
     * 1000001
     * 1000001
     * 1000001
     * 1000001
     * 1111111
     * 예제 출력 4
     * 13
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

            //끝에 도달시 break
            if(check[N][M]==true) break;

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

                //이동불가한 칸이면 패스
                if(intarr[curRow][curCol]==0) continue;

                //이동할 수 있는 조건
                if(intarr[curRow][curCol]==1) {
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

    public int bfs(int row, int col, int time) {

        Queue<Node> queue = new LinkedList<>();
        check[row][col] = true;
        queue.offer(new Node(row, col, time));

        int minTime = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            //끝에 도달시 break
            if(check[N][M]==true) break;

            //상하좌우 순서로 이동
            for(int j=0; j<4; j++) {
                int curRow = curNode.row + dx[j];
                int curCol = curNode.col + dy[j];
                int curTime = curNode.time;

                //범위 초과시 패스
                if(curRow<1 || curRow>N || curCol<1 || curCol>M) continue;

                //방문한 곳이면 패스
                if(check[curRow][curCol]==true) continue;

                //이동불가한 칸이면 패스
                if(intarr[curRow][curCol]==0) continue;

                //이동할 수 있는 조건
                if(intarr[curRow][curCol]==1) {
                    check[curRow][curCol] = true;
                    minTime = curTime+1;
                    queue.offer(new Node(curRow,curCol,curTime+1));
                }
            }
        }
        return minTime;
    }

    public static void main(String[] args) throws IOException {
        DFSBFS_9 main = new DFSBFS_9();
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
            String[] split = br.readLine().split("");
            for(int j=1;j<=M;j++) {
                intarr[i][j] = Integer.parseInt(split[j-1]);
            }
        }
//        System.out.println(main.dfs(1,1,1));
        System.out.println(main.bfs(1,1,1));
    }
}
