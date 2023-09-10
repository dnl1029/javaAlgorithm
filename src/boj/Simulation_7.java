package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Simulation_7 {

    /**
     * 2563번
     * 문제
     * 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다.
     * 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를
     * 색종이의 변과 도화지의 변이 평행하도록 붙인다. 이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후
     * 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
     *
     *
     *
     * 예를 들어 흰색 도화지 위에 세 장의 검은색 색종이를 그림과 같은 모양으로 붙였다면 검은색 영역의 넓이는 260이 된다.
     *
     * 입력
     * 첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다.
     * 색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고,
     * 두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다.
     * 색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다
     *
     * 출력
     * 첫째 줄에 색종이가 붙은 검은 영역의 넓이를 출력한다.
     *
     * 예제 입력 1
     * 3
     * 3 7
     * 15 7
     * 5 2
     * 예제 출력 1
     * 260
     */

    static class cordinate {
        int x1;
        int x2;
        int y1;
        int y2;

        public int getX1() {
            return x1;
        }

        public int getX2() {
            return x2;
        }

        public int getY1() {
            return y1;
        }

        public int getY2() {
            return y2;
        }

        public cordinate(int x1, int x2, int y1, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    public int solution(ArrayList<cordinate> list, int N) {
        int answer = 0;

        List<cordinate> newList = list.stream().sorted(Comparator.comparing(cordinate::getX1).
                thenComparing(cordinate::getY1)).collect(Collectors.toList());

        int count = 0;

        for(int i=0; i<N-1; i++) {
            if(newList.get(i).getX2() > newList.get(i+1).getX1()) {
                if(newList.get(i).getY1() > newList.get(i+1).getY1() && newList.get(i).getY1() < newList.get(i+1).getY2()) {
                    count+= (newList.get(i).getX2() - newList.get(i+1).getX1())
                            *(newList.get(i+1).getY2()-newList.get(i).getY1());
                }
                else if (newList.get(i).getY1() < newList.get(i+1).getY1() && newList.get(i).getY2()>newList.get(i+1).getY1()) {
                    count += (newList.get(i).getX2() - newList.get(i+1).getX1())
                            *(newList.get(i).getY2() - newList.get(i+1).getY1());
                }
            }
        }
        answer = 100*N - count;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Simulation_7 main = new Simulation_7();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<cordinate> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = x1+10;
            int y2 = y1+10;
            cordinate cor = new cordinate(x1,x2,y1,y2);
            list.add(cor);
        }
        br.close();
        System.out.println(main.solution(list,N));
    }
}
