import java.util.Arrays;
import java.util.Scanner;

public class Q3_4 {

    /**
     *설명
     *
     * N개의 수로 이루어진 수열이 주어집니다.
     *
     * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
     *
     * 만약 N=8, M=6이고 수열이 다음과 같다면
     *
     * 1 2 1 3 1 1 1 2
     *
     * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
     *
     *
     * 입력
     * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
     *
     * 수열의 원소값은 1,000을 넘지 않는 자연수이다.
     *
     *
     * 출력
     * 첫째 줄에 경우의 수를 출력한다.
     *
     *
     * 예시 입력 1
     *
     * 8 6
     * 1 2 1 3 1 1 1 2
     * 예시 출력 1
     *
     * 3
     */

    public int solution(String str1, String str2) {
        int answer = 0;

        String[] strarr1 = str1.split(" ");
        String[] strarr2 = str2.split(" ");
        int[] intarr = Arrays.stream(strarr2).mapToInt(i -> Integer.parseInt(i)).toArray();
        int N = Integer.parseInt(strarr1[0]);
        int M = Integer.parseInt(strarr1[1]);
        int temp=0;
        int x=0;
        for(int i=0;i<N;i++) {
            temp += intarr[i];
            if(temp==M) {
                answer++;
            }
            while (temp>=M) {
                temp -= intarr[x++];
                if(temp==M) {
                    answer++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Q3_4 main = new Q3_4();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(main.solution(str1,str2));
    }

}
