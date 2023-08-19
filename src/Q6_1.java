import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Q6_1 {

    /**
     *설명
     *
     * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     *
     * 정렬하는 방법은 선택정렬입니다.
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

    public String solution(ArrayList list, int N) {
        String answer = "";

        //선택정렬
        //1.주어진 리스트에서 최솟값을 찾는다.
        //2. 최솟값을 맨 앞 자리의 값과 교환한다.
        //3. 맨 앞 자리를 제외한 나머지 값들 중 최솟값을 찾아 위와 같은 방법으로 반복한다.
        //list stream으로 int 캐스팅할때, (int)로 해야함

        for(int i=0;i<N;i++) {
            int temp = 0;
            int count = 0;
            temp = (int)list.get(i);
            for (int j=i+1;j<N;j++) {
                if((int)list.get(j)<temp) {
                    count = j;
                    temp = (int)list.get(j);
                    int target = (int)list.get(i);
                    list.set(i,temp);
                    list.set(count,target);
                }
            }
        }
        answer = list.stream().map(i->i.toString() + " ").collect(Collectors.joining()).toString().trim();
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Q6_1 main = new Q6_1();
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
