import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class OldQ2 {
    public static void main(String[] args) {
        /**
         * 점수 x의 최대값이 M 일때, 수정된 점수는 (x/M)*100. 이때 평균 구하기
         * 1번째 input : 시험 본 과목수 N(0<N<=1000)
         * 2번째 input : 현재 성적.(0<=성적<=100, 1개 이상은 0보다 큼)
         * ex)
         * 3
         * 10 20 30 -> sum값은 66.6
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] intarr = new int[N];
        for (int i=0;i<N;i++) {
            intarr[i] = sc.nextInt();
        }
        int max = Arrays.stream(intarr).max().getAsInt();
        System.out.println("max : "+max);

        //list.stream().map(i -> (i / max) * 100).forEach(f -> System.out.println("list : "+f));
        Arrays.stream(intarr).map(i->i*100).forEach(f->System.out.println("longarr : "+f));
        OptionalDouble average = Arrays.stream(intarr).map(i -> i * 100).average();
        Double newaverage = average.getAsDouble()/max;
        System.out.println("newaverage : "+newaverage);

    }
}