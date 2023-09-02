import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Greedy_2 {

    /**
     * 1931번 회의실 배정(활동 선택 문제).
     * 한 사람이 하나의 활동에 대해서만 작업할 수 있을 때 최대한 많은 활동을 할 수 있는 수를 선택하는 문제다
     * 한 사람이 하나의 활동에 대해서만 작업할 수 있다'라는 점이다.
     * 즉, 하나의 활동을 완료하기 전까지는 다른 활동을 선택할 수 없다는 것이다.
     * '탐욕 선택이 이후의 결과에 영향을 미치지 않는다.'
     * == 종료 시간을 기준으로 정렬해서 풀기.
     *
     * 문제
     * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
     * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고,
     * 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
     * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
     * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
     *
     * 입력
     * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
     * 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
     * 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
     *
     * 출력
     * 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
     *
     * 예제 입력 1
     * 11
     * 1 4
     * 3 5
     * 0 6
     * 5 7
     * 3 8
     * 5 9
     * 6 10
     * 8 11
     * 8 12
     * 2 13
     * 12 14
     * 예제 출력 1
     * 4
     *
     */

    static class room {
        int startTime;
        int endTime;

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public room(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public int solution(int N, ArrayList<room> list) {

        int count = 0;

        //list를 종료기준으로 정렬 후 시작기준으로 정렬
        List<room> sortedList = list.stream().sorted(Comparator.comparing(room::getEndTime).thenComparing(room::getStartTime)).collect(Collectors.toList());

        int minEndTime = 0;
        for(int i=0; i<N; i++) {
            //0일때 초기화
            if(i==0) {
                minEndTime = sortedList.get(i).getEndTime();
                count++;
                continue;
            }
            //이전 종료시간이, 다음 시작시간보다 작거나 같을때 회의실 배정가능
            if(minEndTime<=sortedList.get(i).getStartTime()) {
                minEndTime = sortedList.get(i).getEndTime();
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Greedy_2 main = new Greedy_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //회의실 개수
        int N = Integer.parseInt(br.readLine());

        ArrayList<room> list = new ArrayList<>();

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new room(a,b));
        }

        br.close();
        System.out.println(main.solution(N, list));
//        System.out.println(main.solution(N,K,coinList));
    }
}
