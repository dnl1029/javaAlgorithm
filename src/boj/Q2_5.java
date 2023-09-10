package boj;

import java.util.Scanner;

public class Q2_5 {

    /**
     *설명
     *
     * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
     *
     * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
     *
     *
     * 입력
     * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
     *
     *
     * 출력
     * 첫 줄에 소수의 개수를 출력합니다.
     *
     *
     * 예시 입력 1
     *
     * 20
     * 예시 출력 1
     *
     * 8
     */

    public int solution(int N) {
        int answer = 0;
        //아래는 소수 구하는 2중 for문
//        for(int i=2;i<N;i++) {
//            for(int j=2;j<N;j++) {
//                if(i!=j&&i%j==0) {
//                    break;
//                }
//                if(i==j) {
//                    answer++;
//                }
//            }
//        }

        //소수구하기는 에라토스테네스체가 가장 빠르다.
        int[] chars = new int[N+1];
        for(int i=2; i<=N;i++) {
            if(chars[i]==0) {
                answer++;
                for(int j=i; j<=N;j=j+i) {
                    chars[j] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Q2_5 main = new Q2_5();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(main.solution(N));
    }

}
