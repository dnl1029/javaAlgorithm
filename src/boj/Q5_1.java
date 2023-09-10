package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q5_1 {

    /**
     *설명
     *
     * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
     *
     * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
     *
     *
     *
     * 입력
     * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
     *
     *
     * 출력
     * 첫 번째 줄에 YES, NO를 출력한다.
     *
     *
     * 예시 입력 1
     *
     * (()(()))(()
     * 예시 출력 1
     *
     * NO
     */

    public String solution(String str) {
        String answer = "";

        Stack<Character> stack = new Stack<>();
        boolean res = true;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            else if(str.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    res = false;
                    break;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) {
            res = false;
        }

//        int lc = 0;
//        int rc = 0;
//        boolean res = true;
//        for(int i=0;i<str.length();i++) {
//            if(str.charAt(i) == '(') {
//                lc++;
//            }
//            else if(str.charAt(i) == ')') {
//                rc++;
//            }
//            if(lc<rc) {
//                res = false;
//            }
//        }
//        if(lc!=rc) {
//            res = false;
//        }
//
        if(res == true) {
            answer = "YES";
        }
        else {
            answer = "NO";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q5_1 main = new Q5_1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        System.out.println(main.solution(str));
    }

}
