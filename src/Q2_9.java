import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Q2_9 {

    /**
     *설명
     *
     * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
     *
     * Image1.jpg
     *
     * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
     *
     *
     * 입력
     * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
     *
     * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
     *
     *
     * 출력
     * 최대합을 출력합니다.
     *
     *
     * 예시 입력 1
     *
     * 5
     * 10 13 10 12 15
     * 12 39 30 23 11
     * 11 25 50 53 15
     * 19 27 29 37 27
     * 19 13 30 13 19
     * 예시 출력 1
     *
     * 155
     */

    public int solution(int[][] intarr, int N) {
        int answer = 0;
        int d1=0;
        int d2=0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            int rowsum = 0;
            int colsum = 0;
            for(int j=0;j<N;j++) {
                if(i==j) {
                    d1 += intarr[i][j];
                }
                else if(i+j==N-1) {
                    d2 += intarr[i][j];
                }
                rowsum += intarr[i][j];
                colsum += intarr[j][i];
            }
            list.add(rowsum);
            list.add(colsum);
        }
        list.add(d1);
        list.add(d2);
        //Integer -> int는 i.intValue, String -> int는 Integer.parseInt(s) 이렇게.
        OptionalInt max = list.stream().mapToInt(i -> i.intValue()).max();
        answer = max.getAsInt();
        return answer;
    }

    public static void main(String[] args) {
        Q2_9 main = new Q2_9();
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] intarr = new int[N][N];
        for(int i=0;i<N;i++) {
            intarr[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(j->Integer.parseInt(j)).toArray();
        }
        System.out.println(main.solution(intarr,N));
    }

}
