import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q5_4 {

    /**
     *설명
     *
     * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
     *
     * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
     *
     *
     * 입력
     * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
     *
     * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
     *
     *
     * 출력
     * 연산한 결과를 출력합니다.
     *
     *
     * 예시 입력 1
     *
     * 352+*9-
     * 예시 출력 1
     *
     * 12
     */

    public int solution(String str) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        String[] strarr = str.split("");
        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<str.length();i++) {
            if(Character.isDigit(strarr[i].charAt(0))){
                stack.push(Integer.parseInt(strarr[i]));
            }
            else {
                int end = stack.pop().intValue();
                int front = stack.pop().intValue();
                if(strarr[i].equals("+")) {
                    stack.push(front+end);
                }
                else if(strarr[i].equals("-")){
                    stack.push(front-end);
                }
                else if(strarr[i].equals("*")){
                    stack.push(front*end);
                }
                else if(strarr[i].equals("/")){
                    stack.push(front/end);
                }
            }
        }
        answer= stack.get(0).intValue();

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q5_4 main = new Q5_4();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        System.out.println(main.solution(str));
    }

}
