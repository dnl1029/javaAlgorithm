package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7_1 {

    /**
     * DFS
     * 부분집합 구하기
     * 입력 3
     *
     * 출력 3
     * 1
     * 2
     * 3
     * 1 2
     * 1 3
     * 2 3
     * 1 2 3
     */
    static int n;
    static int[] ch;

    public void dfs(int L) {
        if(L==n+1) {
            String tmp = "";
            for(int i=1;i<=n;i++) {
                if(ch[i]==1) tmp+= i+" ";
            }
            if(tmp.length()>0) {
                System.out.println(tmp);
            }
        }
        else {
            ch[L] = 1;
            dfs(L+1);
            ch[L] = 0;
            dfs(L+1);
        }
    }

    public static void main(String[] args) throws IOException {
        Q7_1 main = new Q7_1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        int N = Integer.parseInt(br.readLine());
//        ch = new int[N+1];
        n=3;
        ch=new int[n+1];


        br.close();
        main.dfs(1);
    }
}
