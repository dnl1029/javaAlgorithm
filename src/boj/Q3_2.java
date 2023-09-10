package boj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q3_2 {

    /**
     *설명
     *
     * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
     *
     *
     * 입력
     * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
     *
     * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
     *
     * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
     *
     * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
     *
     * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
     *
     *
     * 출력
     * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
     *
     *
     * 예시 입력 1
     *
     * 5
     * 1 3 9 5 2
     * 5
     * 3 2 5 7 8
     * 예시 출력 1
     *
     * 2 3 5
     */

    public String solution(int N, String strN, int M, String strM) {
        String answer = "";

        //주의 set에 add하는 행동은 map이 아니라 foreach에 짜야함
        //아래는 or 조건으로 합치는 방법
        //String str= strN + " "+ strM;
        // set을 stream으로 해서 add하면됨. 코드는 생략

        String[] strarr1 = strN.split(" ");
        String[] strarr2 = strM.split(" ");
        HashSet<Integer> set = new HashSet<>();

        //시간복잡도 걸리면 N2 -> 투포인터알고리즘으로. 투포인터할때는 항상 오름차순 정렬되어야.
//        for(int i=0; i<N; i++) {
//            for(int j=0; j<N; j++) {
//                if(strarr1[i].equals(strarr2[j])) {
//                    set.add(Integer.valueOf(strarr1[i]));
//                }
//            }
//        }
        //Integer -> String은 i.toString, int -> String은 String.valueof(i)
//        answer = set.stream().sorted().map(i -> i.toString() + " ").collect(Collectors.joining()).trim();

        int[] intarr1 = Arrays.stream(strarr1).mapToInt(i -> Integer.parseInt(i)).sorted().toArray();
        int[] intarr2 = Arrays.stream(strarr2).mapToInt(i -> Integer.parseInt(i)).sorted().toArray();

        int i=0;
        int j=0;
        while (i<N && j<M) {
            if(intarr1[i] == intarr2[j]) {
                set.add(intarr1[i]);
                i++;
                j++;
            }
            else if(intarr1[i] < intarr2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        answer = set.stream().sorted().map(x -> x.toString() + " ").collect(Collectors.joining()).trim();

        return answer;
    }

    public static void main(String[] args) {
        Q3_2 main = new Q3_2();
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String strN = sc.nextLine();
        int M = Integer.parseInt(sc.nextLine());
        String strM = sc.nextLine();
        System.out.println(main.solution(N,strN,M,strM));
    }

}
