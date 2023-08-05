import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q2_1 {

    /**
     *설명
     *
     * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
     *
     * (첫 번째 수는 무조건 출력한다)
     *
     *
     * 입력
     * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
     *
     *
     * 출력
     * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
     *
     *
     * 예시 입력 1
     *
     * 6
     * 7 3 9 5 6 12
     * 예시 출력 1
     *
     * 7 9 6 12
     */

    public String solution(String str, int N) {
        String answer = "";

        String[] strarr = str.split(" ");
        //stream을 배열로 변환하려면 .toArray()
        int[] intarr = Arrays.stream(strarr).mapToInt(i -> Integer.parseInt(i)).toArray();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            if(i==0) {
                list.add(intarr[i]);
            }
            else if(intarr[i-1] < intarr[i]){
                list.add(intarr[i]);
            }
        }

        //Integer -> String은 .map 사용후 i.toString
        //int ->String은 .maptoObj 사용후 String.valueof(i) 사용
        answer = list.stream().map(i -> i.toString() + " ").collect(Collectors.joining());

        return answer;
    }

    public static void main(String[] args) {
        Q2_1 main = new Q2_1();
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        System.out.println(main.solution(str,N));
    }

}
