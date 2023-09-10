package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Q6_2 {

    /**
     *설명
     *
     * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     *
     * 정렬하는 방법은 버블정렬입니다.
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
     * 13 5 11 7 23 15
     * 예시 출력 1
     *
     * 5 7 11 13 15 23
     */

    public String solution(ArrayList list,int N) {
        String answer = "";

        //버블정렬
        //1. 앞에서부터 현재 원소와 바로 다음 원소 비교
        //2. 현재 원소가 다음 원소보다 크면 원소를 교환
        //3. 다음 원소로 이동하여 해당 원소와 그 다음원소를 비교

        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                if((int)list.get(j) < (int)list.get(j-1)) {
                    int temp = (int)list.get(j);
                    list.set(j,(int)list.get(j-1));
                    list.set(j-1,temp);
                }
            }
        }
        answer = list.stream().map(i->i.toString()+ " ").collect(Collectors.joining()).toString().trim();
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q6_2 main = new Q6_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N;i++) {
            list.add(Integer.parseInt(st2.nextToken()));
        }
        br.close();
        System.out.println(main.solution(list,N));
    }

}
