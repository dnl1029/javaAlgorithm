package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bruto_1 {

    /**
     * 1527번
     * 문제
     * 은민이는 4와 7을 좋아하고, 나머지 숫자는 싫어한다. 금민수는 어떤 수가 4와 7로만 이루어진 수를 말한다.
     *
     * A와 B가 주어졌을 때, A보다 크거나 같고, B보다 작거나 같은 자연수 중에 금민수인 것의 개수를 출력하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 A와 B가 주어진다. A는 1보다 크거나 같고, 1,000,000,000보다 작거나 같은 자연수이다.
     * B는 A보다 크거나 같고, 1,000,000,000보다 작거나 같은 자연수이다.
     *
     * 출력
     * 첫째 줄에 A보다 크거나 같고, B보다 작거나 같은 자연수 중에 금민수인 것의 개수를 출력한다.
     *
     * 예제 입력 1
     * 1 10
     * 예제 출력 1
     * 2
     * 예제 입력 2
     * 11 20
     * 예제 출력 2
     * 0
     * 예제 입력 3
     * 74 77
     * 예제 출력 3
     * 2
     * 예제 입력 4
     * 1000000 5000000
     * 예제 출력 4
     * 64
     */

    public int solution(int a, int b) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=a;i<=b;i++) {
            String str = String.valueOf(i);
            boolean bool = true;
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j)=='4' || str.charAt(j)=='7') {
                }
                else {
                    bool = false;
                }
            }
            if(bool) {
                list.add(i);
            }
        }
        answer = list.size();
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Bruto_1 main = new Bruto_1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        br.close();
        System.out.println(main.solution(a,b));
    }
}
