package boj;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("1");

        int[] intarr = new int[3];
        intarr[0] = 5;
        intarr[1] = 10;
        intarr[2] = 20;

        String collect = Arrays.stream(intarr).mapToObj(i -> "hi"+String.valueOf(i)).collect(Collectors.joining());
        System.out.println(collect);

        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(10);
        integerList.add(15);

        List<String> collect1 = integerList.stream().mapToInt(i -> i).min().stream().mapToObj(j -> String.valueOf(j)).collect(Collectors.toList());
        System.out.println(collect1.get(0));


    }

}
