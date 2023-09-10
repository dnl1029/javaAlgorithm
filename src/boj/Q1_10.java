package boj;

import java.util.*;
import java.util.stream.Collectors;

public class Q1_10 {

    /**
     *설명
     * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
     * 입력
     * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
     * 문자열의 길이는 100을 넘지 않는다.
     * 출력
     * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
     * 예시 입력 1
     * teachermode e
     * 예시 출력 1
     * 1 0 1 2 1 0 1 2 2 1 0
     */

    public String solution(String str) {
        String answer = "";
        String[] strs = str.split(" ");
        String originStr = strs[0];
        String compareStr = strs[1];

        char compare = compareStr.charAt(0);
        char[] chars = originStr.toCharArray();
        int[] ints = new int[originStr.length()];

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<originStr.length();i++){
            if(chars[i]==compare) {
                list.add(i);
                ints[i]=0;
            }
        }
        for(int i=0;i<originStr.length();i++){
            if(chars[i] != compare) {
                int newI = i;
                //OptionalInt min = list.stream().mapToInt(Integer::intValue).map(j -> Math.abs(j - newI)).min();
                OptionalInt min = list.stream().mapToInt(k -> k.intValue()).map(j -> Math.abs(j - newI)).min();
                ints[i] = min.getAsInt();
            }
        }

        //array -> string 변환
        String tempStr = Arrays.stream(ints).mapToObj(j -> String.valueOf(j) + " ").collect(Collectors.joining()).trim();
//        answer = Arrays.toString(ints);
        answer += tempStr;
        return answer;
    }

    public static void main(String[] args) {
        Q1_10 main = new Q1_10();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(main.solution(str));
    }

}
