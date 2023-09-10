package boj;

import java.util.Scanner;

public class Q1_5 {

    /**
     *설명
     * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
     * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
     * 입력
     * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
     * 출력
     * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
     * 예시 입력 1
     * a#b!GE*T@S
     * 예시 출력 1
     * S#T!EG*b@a
     */

    public String solution(String str) {
        String answer = "";

        char[] chars = str.toCharArray();
        int frontIndex = 0;
        int endIndex = str.length()-1;

        while(frontIndex < endIndex) {
            if(!Character.isAlphabetic(chars[frontIndex])) {
                frontIndex++;
            }
            else if(!Character.isAlphabetic(chars[endIndex])) {
                endIndex--;
            }
            else {
                char temp = chars[frontIndex];
                chars[frontIndex] = chars[endIndex];
                chars[endIndex] = temp;
                frontIndex++;
                endIndex--;
            }
        }

        for(int i=0;i<str.length();i++){
            answer += chars[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Q1_5 main = new Q1_5();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(main.solution(str));
    }

}