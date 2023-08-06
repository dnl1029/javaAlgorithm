import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1_1 {

    /**
     * 설명
     * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
     * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
     * 입력
     * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     * 출력
     * 첫 줄에 해당 문자의 개수를 출력한다.
     * 예시 입력 1
     * Computercooler
     * c
     * 예시 출력 1
     * 2
     */

    public int solution(String str, char t) {
        int answer = 0;

        String newString = str.toUpperCase();
        char newChar = Character.toUpperCase(t);

//        System.out.println("str: "+newString);
//        System.out.println("char: "+newChar);

        //String의 문자열을 for문으로 돌리려면, newString.charAt(i)로 해야함.
//        for(int i =0;i<newString.length();i++) {
//            if(newString.charAt(i)==newChar) {
//                answer++;
//            }
//        }
        //for each문. char x : char배열.
        for(char x : newString.toCharArray()){
            if(x==newChar) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q1_1 main = new Q1_1();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String str2 = br.readLine();
        char c = str2.charAt(0);

        System.out.println(main.solution(str,c));
    }
}
