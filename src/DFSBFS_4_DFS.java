import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSBFS_4_DFS {

    /**
     * 문제
     * 해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다. 이 회사는 N개의 컴퓨터로 이루어져 있다. 김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.
     *
     * 이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.
     *
     * 이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.
     *
     * 출력
     * 첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.
     *
     * 예제 입력 1
     * 5 4
     * 3 1
     * 3 2
     * 4 3
     * 5 3
     * 예제 출력 1
     * 1 2
     */

    static int[][] intarr;
    static int N;
    static int M;

    public int dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] check = new boolean[N+1];
        int count = 0;
        check[start] = true;
        stack.push(start);
        while (!stack.isEmpty()) {
            int cur = stack.peek().intValue();
            boolean flag = false;
            for (int j = 1; j <= N; j++) {
                if (check[j] == false && intarr[cur][j] == 1) {
                    check[j] = true;
                    stack.push(j);
                    count++;
                    flag = true;
                }
            }
            if(!flag) {
                stack.pop();
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        DFSBFS_4_DFS main = new DFSBFS_4_DFS();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        //인접행렬 구현
        intarr = new int[N+1][N+1];

        for(int i=1; i<=M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            //a가 b를 신뢰한다 = b가 감영되면 a도 감염된다 = b에서 a로 단방향으로 갈수있다.
            intarr[b][a] = 1;
        }
        br.close();

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=N;i++) {
            map.put(i,main.dfs(i));
        }
        int max = map.entrySet().stream().mapToInt(i -> i.getValue()).max().getAsInt();

        String answer = "";
        for(int i=1;i<=N;i++) {
            if(map.get(i)==max) {
                answer += String.valueOf(i) + " ";
            }
        }
        System.out.println(answer.trim());
    }
}
