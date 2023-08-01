import java.util.*;
import java.util.stream.Collectors;

public class Q1_3 {

    /**
     *설명
     * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
     * 문장속의 각 단어는 공백으로 구분됩니다.
     * 입력
     * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
     * 출력
     * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
     * 단어를 답으로 합니다.
     * 예시 입력 1
     * it is time to study
     * 예시 출력 1
     * study
     */

    public String solution(String str) {
        String answer = "";
//        System.out.println(str);
        String[] split = str.split(" ");
        int max = 0;
        for(String x : split){
//            System.out.println(x);
            int length = x.length();
            if(length > max) {
                max = length;
                answer = x;
            }
        }
//        List<Integer> collect = Arrays.stream(split).map(i -> i.length()).collect(Collectors.toList());
//        OptionalInt max = collect.stream().mapToInt(x -> x).max();


        return answer;
    }

    public static void main(String[] args) {
        Q1_3 main = new Q1_3();
        Scanner sc = new Scanner(System.in);

        //주의 next()로하면 공백 포함되지 않음. nextline해야함
        String str = sc.nextLine();
        System.out.println(main.solution(str));
    }

}
