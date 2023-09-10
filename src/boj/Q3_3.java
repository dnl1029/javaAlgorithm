package boj;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Q3_3 {

    /**
     *설명
     *
     * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
     *
     * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
     *
     * 12 1511 20 2510 20 19 13 15
     *
     * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
     *
     * 여러분이 현수를 도와주세요.
     *
     *
     * 입력
     * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
     *
     * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
     *
     *
     * 출력
     * 첫 줄에 최대 매출액을 출력합니다.
     *
     *
     * 예시 입력 1
     *
     * 10 3
     * 12 15 11 20 25 10 20 19 13 15
     * 예시 출력 1
     *
     * 56
     */

    public int solution(String str1, String str2) {
        int answer = 0;

        String[] strarr1 = str1.split(" ");
        String[] strarr2 = str2.split(" ");
        int[] intarr = Arrays.stream(strarr2).mapToInt(i -> Integer.parseInt(i)).toArray();
        int num = Integer.parseInt(strarr1[0]);
        int x = Integer.parseInt(strarr1[1]);

        int[] newintarr = new int[num-x+1];
        for(int i=0;i<num-x+1;i++) {
            newintarr[i] = intarr[i] + intarr[i+1]+ intarr[i+2];
        }
        OptionalInt max = Arrays.stream(newintarr).max();
        answer = max.getAsInt();
        return answer;
    }

    public static void main(String[] args) {
        Q3_3 main = new Q3_3();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(main.solution(str1,str2));
    }

}
