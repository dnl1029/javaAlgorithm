package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q5_2 {

    /**
     *설명
     *
     * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
     *
     *
     * 입력
     * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
     *
     *
     * 출력
     * 남은 문자만 출력한다.
     *
     *
     * 예시 입력 1
     *
     * (A(BC)D)EF(G(H)(IJ)K)LM(N)
     * 예시 출력 1
     *
     * EFLM
     */

    public String solution(String str) {
        String answer = "";

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)==')') {
                while (stack.pop() != '(') {}
            }
            else {
                stack.push(str.charAt(i));
            }
        }
        for(int j=0;j<stack.size();j++) {
            answer += stack.get(j);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q5_2 main = new Q5_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        System.out.println(main.solution(str));
    }

}
