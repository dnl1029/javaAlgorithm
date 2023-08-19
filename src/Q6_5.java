import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q6_5 {

    /**
     *설명
     *
     * 현수네 반에는 N명의 학생들이 있습니다.
     *
     * 선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
     *
     * 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
     *
     * N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
     *
     *
     * 입력
     * 첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.
     *
     * 두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.
     *
     *
     * 출력
     * 첫 번째 줄에 D 또는 U를 출력한다.
     *
     *
     * 예시 입력 1
     *
     * 8
     * 20 25 52 30 39 33 43 33
     * 예시 출력 1
     *
     * D
     */

    public String solution(ArrayList list, int N) {
        String answer = "";

        HashSet<Integer> set = new HashSet<>();
        list.stream().mapToInt(i->(int)i).forEach(j->set.add(j));
        if(set.size()==N) {
            answer = "U";
        }
        else {
            answer = "D";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q6_5 main = new Q6_5();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        br.close();
        System.out.println(main.solution(list,N));
    }

}
