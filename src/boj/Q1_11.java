package boj;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q1_11 {

    /**
     *설명
     * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
     * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
     * 단 반복횟수가 1인 경우 생략합니다.
     * 입력
     * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
     * 출력
     * 첫 줄에 압축된 문자열을 출력한다.
     * 예시 입력 1
     * KKHSSSSSSSE
     * 예시 출력 1
     * K2HS7E
     * 예시 입력 2
     * KSTTTSEEKFKKKDJJGG
     * 예시 출력 2
     * KST3SE2KFK3DJ2G2
     */

    public String solution(String str) {
        String answer = "";

        /**
         * 중요. 다짜고짜 str.toCharArray()하면 복잡해질수 있으니
         * string.charAt(i) for문 만으로 해결 가능하면 이걸로 하기
         */
        String newstr = str;
        String newanswer = "";

        int newcount = 1;
        for(int i=0; i<newstr.length();i++){
            if(i==newstr.length()-1) {
                if(newstr.charAt(i) == newstr.charAt(i-1)){
                    newanswer += newstr.charAt(i);
                    newanswer += String.valueOf(newcount);
                    break;
                }
                else {
                    newanswer += newstr.charAt(i);
                    break;
                }
            }
            if(newstr.charAt(i)==newstr.charAt(i+1)){
                newcount++;
            }
            else {
                newanswer += newstr.charAt(i);
                if(newcount >1) {
                    newanswer += String.valueOf(newcount);
                    newcount = 1;
                }
            }
        }

        System.out.println("newanswer " + newanswer);




        char[] orgChars = str.toCharArray();
        LinkedHashSet<Character> charSet = new LinkedHashSet<>();
        for(char x : orgChars) {
            charSet.add(x);
        }
        //char 배열 stream 하는법
        //Stream<Character> characterStream = new String(orgChars).chars().mapToObj(c->(char)c);

        //string을 그냥 바로 char stream 하는법
        //str.chars().filter(f->f=='k').count();

        //아래는 전체 개수 구하는 방법.
        LinkedHashMap<String,String> hashMap = new LinkedHashMap<>();
        for(char x : charSet) {
            long count = str.chars().filter(f -> f == x).count();
            if(count==1){
                hashMap.put(String.valueOf(x),"");
            }
            else {
                hashMap.put(String.valueOf(x),String.valueOf(count));
            }
        }

        LinkedHashMap<String,String> hashMap2 = new LinkedHashMap<>();
        int count=1;
        for(int i=0;i<str.length();i++) {
            if(i==str.length()-1){
                if(orgChars[i] == orgChars[i-1]) {
                    hashMap2.put(String.valueOf(orgChars[i]),String.valueOf(count));
                    answer += hashMap2.entrySet().stream().map(j->j.getKey() + j.getValue()).collect(Collectors.joining());
                    hashMap2.clear();
                    break;
                }
                hashMap2.put(String.valueOf(orgChars[i]),"");
                answer += hashMap2.entrySet().stream().map(j->j.getKey() + j.getValue()).collect(Collectors.joining());
                hashMap2.clear();
                break;
            }
            else if(orgChars[i]==orgChars[i+1]) {
                count++;
            }
            else {
                hashMap2.put(String.valueOf(orgChars[i]),String.valueOf(count));
                count=1;
                if(hashMap2.get(String.valueOf(orgChars[i])).equals("1")){
                    hashMap2.replace(String.valueOf(orgChars[i]),"");
                }
                answer += hashMap2.entrySet().stream().map(j->j.getKey() + j.getValue()).collect(Collectors.joining());
                hashMap2.clear();
            }
        }

        String anotheranswer = hashMap.entrySet().stream().map(i -> i.getKey() + i.getValue()).collect(Collectors.joining());

        return answer;
    }

    public static void main(String[] args) {
        Q1_11 main = new Q1_11();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(main.solution(str));
    }

}
