import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Template_BFS_Node {

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


    public int bfs(int row, int col, int time) {

        Queue<Node> queue = new LinkedList<>();
        check[row][col] = true;
        queue.offer(new Node(row, col, time));

        int minTime = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

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
                    queue.offer(new Node(curRow,curCol,curTime+1));
                }
            }
        }
        return minTime;
    }

    public static void main(String[] args) throws IOException {
        Template_BFS_Node main = new Template_BFS_Node();
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
        System.out.println(main.bfs(4,6,0));
    }
}
