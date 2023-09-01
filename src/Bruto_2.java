import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Bruto_2 {

    /**
     * 1107번
     * 문제
     * 수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.
     *
     * 리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고,
     * -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
     *
     * 수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때,
     * 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
     *
     * 수빈이가 지금 보고 있는 채널은 100번이다.
     *
     * 입력
     * 첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.
     * 둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다.
     * 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.
     *
     * 출력
     * 첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.
     *
     * 예제 입력 1
     * 5457
     * 3
     * 6 7 8
     * 예제 출력 1
     * 6
     * 예제 입력 2
     * 100
     * 5
     * 0 1 2 3 4
     * 예제 출력 2
     * 0
     * 예제 입력 3
     * 500000
     * 8
     * 0 2 3 4 6 7 8 9
     * 예제 출력 3
     * 11117
     * 예제 입력 4
     * 100
     * 3
     * 1 0 5
     * 예제 출력 4
     * 0
     * 예제 입력 5
     * 14124
     * 0
     * 예제 출력 5
     * 5
     * 예제 입력 6
     * 1
     * 9
     * 1 2 3 4 5 6 7 8 9
     * 예제 출력 6
     * 2
     * 예제 입력 7
     * 80000
     * 2
     * 8 9
     * 예제 출력 7
     * 2228
     */

    public int solution(int N, int M, ArrayList<Integer> brokenList) {

        LinkedList<Integer> numList = new LinkedList<>();

        for(int j=1;j<=9;j++) {
            if(brokenList.contains(j)) continue;
            numList.add(j);
        }

        List<Character> charBrokenList = brokenList.stream().map(i -> String.valueOf(i).charAt((char) 0)).collect(Collectors.toList());

        int result = Math.abs(N-100);
        for(int i=0; i<=999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean bool = true;
            for(int j=0; j<len; j++) {
                if(charBrokenList.contains(str.charAt(j))) {
                    bool = false;
                    break;
                }
            }
            if(bool) {
                int res2 = Math.abs(N-i) + len;
                result = Math.min(res2,result);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Bruto_2 main = new Bruto_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(M==0) {
            String str = String.valueOf(N);
            int size = str.length();
            System.out.println(size);
        }
        else {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            ArrayList<Integer> brokenList = new ArrayList<>();
            for(int i=0; i<M; i++) {
                int a = Integer.parseInt(st2.nextToken());
                brokenList.add(a);
            }
            System.out.println(main.solution(N,M,brokenList));
        }
        br.close();
    }
}
