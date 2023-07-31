import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q3 {

    public static void main(String[] args) throws IOException {
        /**
         * 합배열 S[i] = S[i-1] + A[i]
         * 구간합 구하는 공식 S[j] - S[i-1]
         * 문제 : 1번째 줄에 수의 개수 N(1<=N<=100,000), 합을 구해ㅑ 하는 횟수 M(1<=M<=100,000)
         * 2번째 줄에 N개의 수가 주어지고, 각수는 1000보다 작거나 같은 자연수
         * 3번째 줄부터는 M개의 줄에 합을 구해야하는 구간 i와 j가 주어짐.
         * 입력값 예시
         *  5 3  // 데이터의 개수(5개), 합 구해야하는 질문갯수(3)
         *  5 4 3 2 1 // 구간합을 구할 대상 배열
         *  1 3  -> 12
         *  2 4  -> 9
         *  5 5  -> 1
         */

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //int형 많이 받기 힘들때, 옆으로 데이터 받는게 StringTokenizer. 아래는 띄어쓰기 기준으로 문자를 분리
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        long[]S = new long[N + 1]; //0번째 index 무시하고자.
        //S[i] = S[i-1] + A[i]
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=1; i<=N; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }


        for(int q=0; q<M; q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }


    }
}
