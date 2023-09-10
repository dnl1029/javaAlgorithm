package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Q6_3 {

    /**
     *설명
     *
     * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     *
     * 정렬하는 방법은 삽입정렬입니다.
     *
     *
     * 입력
     * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
     *
     * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
     *
     *
     * 출력
     * 오름차순으로 정렬된 수열을 출력합니다.
     *
     *
     * 예시 입력 1
     *
     * 6
     * 11 7 5 6 10 9
     * 예시 출력 1
     *
     * 5 6 7 9 10 11
     */

    public String solution(ArrayList list, int N) {
        String answer = "";

        //삽입정렬
        //1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다(첫번째 타깃은 두번째 원소부터 시작)
        //2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작으면 위치를 서로 교환
        //3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복한다.

        for(int i=1;i<N;i++) {
            int target = (int)list.get(i);
            int j = i-1;

            //타겟이 이전 원소보다 크기 전까지만 반복
            while (j>=0 && target< (int)list.get(j)) {
                list.set(j+1,(int)list.get(j));
                    j--;
            }
            list.set(j+1,target);
        }
        answer = list.stream().map(i->i.toString() + " ").collect(Collectors.joining()).toString().trim();

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q6_3 main = new Q6_3();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            list.add(Integer.parseInt(st2.nextToken()));
        }
        br.close();
        System.out.println(main.solution(list,N));
    }

}
