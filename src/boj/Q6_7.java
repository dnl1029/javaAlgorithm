package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q6_7 {

    /**
     *설명
     *
     * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
     *
     * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
     *
     *
     * 입력
     * 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
     *
     * 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
     *
     *
     * 출력
     * N개의 좌표를 정렬하여 출력하세요.
     *
     *
     * 예시 입력 1
     *
     * 5
     * 2 7
     * 1 3
     * 1 2
     * 2 5
     * 3 6
     * 예시 출력 1
     *
     * 1 2
     * 1 3
     * 2 5
     * 2 7
     * 3 6
     */

    public void solution(LinkedList xList, LinkedList yList, int N) {
        //삽입정렬
        //1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다(첫번째 타겟은 두번째 원소부터 시작)
        //2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 다 작다면 위치를 서로 교환한다.
        //3. 그 다음 타겟을 찾아 위와 같은 방법으로 반복한다.
        for(int i=1;i<N;i++) {
            int targetX = (int)xList.get(i);
            int targetY = (int)yList.get(i);
            int j = i-1;
            //타겟이 이전 원소보다 크기 전까지만 반복
            while (j>=0 && targetX < (int)xList.get(j)) {
                xList.set(j+1,(int)xList.get(j));
                yList.set(j+1,(int)yList.get(j));
                j--;
            }
            if(j>=0 && targetX == (int)xList.get(j)) {
                if(targetY<(int)yList.get(j)) {
                    xList.set(j+1,(int)xList.get(j));
                    yList.set(j+1,(int)yList.get(j));
                    j--;
                }
            }
            xList.set(j+1,targetX);
            yList.set(j+1,targetY);
        }
        for(int i=0;i<N;i++) {
            String answer = xList.get(i).toString() + " " + yList.get(i).toString();
            System.out.println(answer);
        }
    }

    public static void main(String[] args) throws IOException {
        Q6_7 main = new Q6_7();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> xList = new LinkedList<>();
        LinkedList<Integer> yList = new LinkedList<>();
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xList.add(Integer.parseInt(st.nextToken()));
            yList.add(Integer.parseInt(st.nextToken()));
        }
        br.close();
        main.solution(xList,yList,N);
//        System.out.println(main.solution(xList,yList,N));
    }

}
