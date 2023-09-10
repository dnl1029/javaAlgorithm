package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q4_5 {

    /**
     *설명
     *
     * 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
     *
     * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
     *
     * 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
     *
     * 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
     *
     *
     * 입력
     * 첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
     *
     *
     * 출력
     * 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
     *
     *
     * 예시 입력 1
     *
     * 10 3
     * 13 15 34 23 45 65 33 11 26 42
     * 예시 출력 1
     *
     * 143
     */

    public int solution(String[] strarr, int M, int N) {
        int answer = 0;
        int[] intarr = Arrays.stream(strarr).mapToInt(i -> Integer.parseInt(i)).toArray();
        HashSet<Integer> set = new HashSet<>();
        //조합으로 3개 뽑는거는 3중 for문
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                for(int k=j+1;k<N;k++) {
                    set.add(intarr[i]+intarr[j]+intarr[k]);
                }
            }
        }
        List<Integer> list = set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        answer = list.get(M-1).intValue();
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q4_5 main = new Q4_5();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        String[] strarr = new String[N];

        int i=0;
        while (st2.hasMoreTokens()) {
            strarr[i] = st2.nextToken();
            i++;
        }

        br.close();
        System.out.println(main.solution(strarr,M,N));
    }

}
