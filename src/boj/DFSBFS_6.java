package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSBFS_6 {

    /**
     * 10451 번
     * 문제
     * 1부터 N까지 정수 N개로 이루어진 순열을 나타내는 방법은 여러 가지가 있다. 예를 들어, 8개의 수로 이루어진 순열 (3, 2, 7, 8, 1, 4, 5, 6)을 배열을 이용해 표현하면
     *
     * \(\begin{pmatrix} 1 & 2 &3&4&5&6&7&8 \\  3& 2&7&8&1&4&5&6 \end{pmatrix}\) 와 같다. 또는, Figure 1과 같이 방향 그래프로 나타낼 수도 있다.
     *
     * 순열을 배열을 이용해
     *
     * \(\begin{pmatrix} 1 & \dots & i & \dots &n \\  \pi_1& \dots& \pi_i & \dots & \pi_n \end{pmatrix}\) 로 나타냈다면, i에서 πi로 간선을 이어 그래프로 만들 수 있다.
     *
     * Figure 1에 나와있는 것 처럼, 순열 그래프 (3, 2, 7, 8, 1, 4, 5, 6) 에는 총 3개의 사이클이 있다. 이러한 사이클을 "순열 사이클" 이라고 한다.
     *
     * N개의 정수로 이루어진 순열이 주어졌을 때, 순열 사이클의 개수를 구하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 순열의 크기 N (2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄에는 순열이 주어지며, 각 정수는 공백으로 구분되어 있다.
     *
     * 출력
     * 각 테스트 케이스마다, 입력으로 주어진 순열에 존재하는 순열 사이클의 개수를 출력한다.
     *
     * 예제 입력 1
     * 2
     * 8
     * 3 2 7 8 1 4 5 6
     * 10
     * 2 1 3 4 5 6 7 9 10 8
     * 예제 출력 1
     * 3
     * 7
     */

//    static int[][] intarr;
//    static int N;
//    static int M;
//    static int count;

    public static HashSet dfs(int start,int N, int[][] intarr, HashSet<Integer> paramSet) {
        Stack<Integer> stack = new Stack<>();
        boolean[] check = new boolean[N+1];
        check[start] = true;
        stack.push(start);
        paramSet.remove(start);
        while (!stack.isEmpty()) {
            int cur = stack.peek().intValue();
            boolean flag = false;
            for(int j=1;j<=N;j++) {
                if(check[j]==false && intarr[cur][j]==1) {
                    check[j] = true;
                    stack.push(j);
                    paramSet.remove(j);
                    flag = true;
                }
            }
            if(!flag) {
                stack.pop();
            }
        }
        return paramSet;
    }

    public static HashSet bfs(int start,int N, int[][] intarr, HashSet<Integer> paramSet) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[N+1];
        check[start] = true;
        queue.offer(start);
        paramSet.remove(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll().intValue();
            for(int j=1;j<=N;j++) {
                if(check[j]==false && intarr[cur][j]==1) {
                    check[j] = true;
                    queue.offer(j);
                    paramSet.remove(j);
                }
            }
        }
        return paramSet;
    }

    public int getCombcount(int N, int[][] intarr, HashSet<Integer> totalSet) {
        int count = 0;
        while (!totalSet.isEmpty()) {
            for(int i=1;i<=N;i++) {
                if(!totalSet.contains(i)) continue;
                int beforeSize = totalSet.size();
                totalSet = bfs(i, N, intarr, totalSet);
                int afterSize = totalSet.size();
                if(beforeSize!=afterSize) {
                    count++;
                }
                if(afterSize==0) {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        DFSBFS_6 main = new DFSBFS_6();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayList<Integer> resultList = new ArrayList<>();

        for(int i=1;i<=T;i++) {
            int N = Integer.parseInt(br.readLine());
            //인접행렬 구현
            int[][] intarr = new int[N+1][N+1];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            HashSet<Integer> totalSet = new HashSet<>();
            for(int j=1;j<=N;j++) {
                int temp = Integer.parseInt(st1.nextToken());
                intarr[j][temp] = 1;
                totalSet.add(j);
            }
            int res = main.getCombcount(N,intarr,totalSet);
            resultList.add(res);
        }

        resultList.stream().forEach(i-> System.out.println(i));
        br.close();
    }
}
