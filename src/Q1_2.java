import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1_2 {

    /**
     *2. 대소문자 변환
     * 설명
     * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
     * 입력
     * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     * 출력
     * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
     * 예시 입력 1
     * StuDY
     * 예시 출력 1
     * sTUdy
     */
    public String solution(String str) {
        String answer = "";
        char[] chars = str.toCharArray();
        String news = str.toUpperCase();
//        System.out.println(news);
        char[] newchars = news.toCharArray();
        char[] result = new char[str.length()];
        for(int x=0; x<str.length();x++) {
            if (chars[x] == newchars[x])
            {
//                System.out.println("대문자 : "+chars[x]);
                result[x] = Character.toLowerCase(chars[x]);
            }
            else {
//                System.out.println("소문자 : "+chars[x]);
                result[x] = Character.toUpperCase(chars[x]);
            }
        }
        //answer = result.toString();
        answer = new String(result);

        //정답 foreach에, Character.isLowerCase 사용
//        for(char x : str.toCharArray()){
//            if(Character.isLowerCase(x)) {
//                answer+=Character.toUpperCase(x);
//            }
//            else{
//                answer+=Character.toLowerCase(x);
//            }
//        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q1_2 main = new Q1_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(main.solution(str));
    }

}
