import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class OldQ1 {
    public static void main(String[] args) {
        //array 특징 : 크기가 정해져야 한다. 값을 삭제하기 어렵다. 인덱스 사용하여 값 접근이 빠르다
        //list 특징 : java에서 제공하는 arraylist로 크기가 미정일때, 값 추가 삭제가 많을때 사용.

        /**
         * 문제 1번. N개의 숫자가 공백없이 써있고, sum값 출력(1<N<100)
         * 첫번째줄에 숫자갯수N, 두번째줄에 숫자N개가 공백없이 주어짐
         * 첫번째 input : 5
         * 두번째 input : 54321 -> sum 15
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String sNum = sc.next();
        sc.close();

        int[] intArray = Stream.of(sNum.split("")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(intArray).reduce(0,(a,b)->  a + b);
        System.out.println("Array Sum = "+sum);

    }
}