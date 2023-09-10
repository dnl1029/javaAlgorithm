package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Greedy_1 {

    /**
     * 11047번 동전 0
     * 문제
     * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
     *
     * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
     *
     * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
     *
     * 출력
     * 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
     *
     * 예제 입력 1
     * 10 4200
     * 1
     * 5
     * 10
     * 50
     * 100
     * 500
     * 1000
     * 5000
     * 10000
     * 50000
     * 예제 출력 1
     * 6
     * 예제 입력 2
     * 10 4790
     * 1
     * 5
     * 10
     * 50
     * 100
     * 500
     * 1000
     * 5000
     * 10000
     * 50000
     * 예제 출력 2
     * 12
     *
     */

    public int solution(int N, int K, ArrayList<Integer> coinList) {

        int count = 0;
        //뒤에서(숫자큰수부터 순차적으로 for문)
        for(int i=N-1;i>=0; i--) {

            if(coinList.get(i)>K) continue;

            if(coinList.get(i)<=K) {
                //몫
                int x = K / coinList.get(i);
                count += x;
                //나머지
                K = K % coinList.get(i);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Greedy_1 main = new Greedy_1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //동전의 종류
        int N = Integer.parseInt(st.nextToken());

        //target
        int K = Integer.parseInt(st.nextToken());

        int [] intarr = new int[N];

        ArrayList<Integer> coinList = new ArrayList<>();

        for(int i=0;i<N;i++) {
            coinList.add(Integer.parseInt(br.readLine()));
        }

        br.close();
        System.out.println(main.solution(N,K,coinList));
    }
}
