package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Simulation_2 {

    /**
     * 2490번
     * 문제
     * 우리나라 고유의 윷놀이는 네 개의 윷짝을 던져서 배(0)와 등(1)이 나오는 숫자를 세어 도, 개, 걸, 윷, 모를 결정한다.
     * 네 개 윷짝을 던져서 나온 각 윷짝의 배 혹은 등 정보가 주어질 때 도(배 한 개, 등 세 개), 개(배 두 개, 등 두 개), 걸(배 세 개, 등 한 개), 윷(배 네 개), 모(등 네 개) 중 어떤 것인지를 결정하는 프로그램을 작성하라.
     *
     * 입력
     * 첫째 줄부터 셋째 줄까지 각 줄에 각각 한 번 던진 윷짝들의 상태를 나타내는 네 개의 정수(0 또는 1)가 빈칸을 사이에 두고 주어진다.
     *
     * 출력
     * 첫째 줄부터 셋째 줄까지 한 줄에 하나씩 결과를 도는 A, 개는 B, 걸은 C, 윷은 D, 모는 E로 출력한다.
     *
     * 예제 입력 1
     * 0 1 0 1
     * 1 1 1 0
     * 0 0 1 1
     * 예제 출력 1
     * B
     * A
     * B
     */

    public void solution(int[][] intarr) {
        for(int i=0;i<3;i++) {
            int temp=0;
            String answer = "";
            for(int j=0;j<4;j++) {
                temp += intarr[i][j];
            }
            if(temp==0) {
                answer = "D";
            }
            else if (temp==1) {
                answer = "C";
            }
            else if (temp==2) {
                answer = "B";
            }
            else if (temp==3) {
                answer = "A";
            }
            else if (temp==4) {
                answer = "E";
            }
            System.out.println(answer);
        }
    }

    public static void main(String[] args) throws IOException {
        Simulation_2 main = new Simulation_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] intarr = new int[3][4];
        for(int i=0;i<3;i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++) {
                intarr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
        br.close();
        main.solution(intarr);
    }
}
