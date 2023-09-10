package boj;

import java.util.Scanner;

public class Q1_8 {

    /**
     *설명
     * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
     * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
     * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
     * 알파벳 이외의 문자들의 무시합니다.
     * 입력
     * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
     * 출력
     * 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
     * 예시 입력 1
     * found7,time:study;Yduts;emit,7Dnuof
     * 예시 출력 1
     * YES
     */

    public String solution(String str) {
        String answer = "";
        String tempstr ="";
        char[] tempChars = str.toCharArray();
        for(char x:tempChars) {
            if(Character.isAlphabetic(x)){
                tempstr += x;
            }
        }
        String upperStr = tempstr.toUpperCase();
        StringBuffer stringBuffer = new StringBuffer(upperStr);
        String reverse = stringBuffer.reverse().toString();
        if(reverse.equals(upperStr)){
            answer = "YES";
        }
        else {
            answer = "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        Q1_8 main = new Q1_8();
        Scanner sc = new Scanner(System.in);
        String strTemp = sc.nextLine();
        //공백제거
        String str = strTemp.replace(" ", "");
        System.out.println(main.solution(str));
    }

}
