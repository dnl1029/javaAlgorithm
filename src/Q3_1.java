import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q3_1 {

    /**
     *설명
     *
     * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
     *
     *
     * 입력
     * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
     *
     * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
     *
     * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
     *
     * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
     *
     * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
     *
     *
     * 출력
     * 오름차순으로 정렬된 배열을 출력합니다.
     *
     *
     * 예시 입력 1
     *
     * 3
     * 1 3 5
     * 5
     * 2 3 6 7 9
     * 예시 출력 1
     *
     * 1 2 3 3 5 6 7 9
     */

    public String solution(int N, String strN, int M, String strM) {
        String answer = "";

        //참고 array 두개 합치는 방법
        //int lenArray1 = Array1.length;
        //int lenArray2 = Array2.length;
        //int[] concate = new int[lenArray1 + lenArray2];
        //System.arraycopy(Array1,0,concate,0,lenArray1);
        //System.arraycopy(Array2,0,concate,lenArray1, lenArray2);


        //아래는 그냥 쉬운 array 정렬방법
        //String str = strN + " " + strM;
        //String[] strarr = str.split(" ");
        //int[] intarr = Arrays.stream(strarr).mapToInt(i -> Integer.parseInt(i)).toArray();
        //array 오름차순 정렬
        //Arrays.sort(intarr);
        //answer = Arrays.stream(intarr).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining());

        //입력 array가 정렬되어 왔기때문에,
        //two point 알고리즘으로, 각 배열의 i, j 를 비교하면서 list에 add하는방식으로 하면 시간복잡도가 더 나음
        String[] strarr1 = strN.split(" ");
        String[] strarr2 = strM.split(" ");
        int[] intarr1 = Arrays.stream(strarr1).mapToInt(i -> Integer.parseInt(i)).toArray();
        int[] intarr2 = Arrays.stream(strarr2).mapToInt(i -> Integer.parseInt(i)).toArray();

        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<N && j<M) {
            if(intarr1[i]<intarr2[j]) {
                list.add(intarr1[i++]);
            }
            else {
                list.add(intarr2[j++]);
            }
        }
        //한쪽만 다없어졌을때 대비
        while (i<N) {
            list.add(intarr1[i++]);
        }
        while (j<M) {
            list.add(intarr2[j++]);
        }
        answer = list.stream().map(x -> x.toString() + " ").collect(Collectors.joining()).trim();

        return answer;
    }

    public static void main(String[] args) {
        Q3_1 main = new Q3_1();
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String strN = sc.nextLine();
        int M = Integer.parseInt(sc.nextLine());
        String strM = sc.nextLine();
        System.out.println(main.solution(N,strN,M,strM));
    }

}
