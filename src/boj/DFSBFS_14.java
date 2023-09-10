package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSBFS_14 {

    /**
     * 2644번
     * 문제
     * 우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.
     * 이러한 촌수는 다음과 같은 방식으로 계산된다. 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를
     * 계산한다. 예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고,
     * 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
     *
     * 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
     *
     * 입력
     * 사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다.
     * 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고,
     * 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다.
     * 그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다.
     * 넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다.
     * 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
     *
     * 각 사람의 부모는 최대 한 명만 주어진다.
     *
     * 출력
     * 입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 이때에는 -1을 출력해야 한다.
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
        DFSBFS_14 main = new DFSBFS_14();
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
