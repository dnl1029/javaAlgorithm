package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Q4_4 {

    /**
     *설명
     *
     * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
     *
     * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
     *
     *
     * 입력
     * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
     *
     * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
     *
     *
     * 출력
     * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
     *
     *
     * 예시 입력 1
     *
     * bacaAacba
     * abc
     * 예시 출력 1
     *
     * 3
     * 힌트
     *
     * 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
     */

    public int solution(String str1, String str2) {
        int answer = 0;
        int N = str1.length();
        int M = str2.length();
        List<Character> compareList = str2.chars().mapToObj(j -> (char) j).sorted().collect(Collectors.toList());

        int count = 0;
        for(int i=0;i<N-M+1;i++) {
            List<Character> templist = str1.substring(i, i + M).chars().mapToObj(j -> (char) j).sorted().collect(Collectors.toList());
            if(templist.equals(compareList)) {
                count++;
            }
        }
        answer = count;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q4_4 main = new Q4_4();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        br.close();
        System.out.println(main.solution(str1,str2));

    }

}
