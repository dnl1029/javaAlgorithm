package boj;

import java.io.IOException;
import java.util.*;

public class Solution_2 {

    /**
     *얀에서는 매년 달리기 경주가 열립니다.
     * 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
     * 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때,
     * 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다.
     * 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.
     *
     * 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을
     * 담은 문자열 배열 callings가 매개변수로 주어질 때, 경주가 끝났을 때 선수들의 이름을 1등부터
     * 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
     *
     * players	callings	result
     * ["mumu", "soe", "poe", "kai", "mine"]	["kai", "kai", "mine", "mine"]	["mumu", "kai", "mine", "soe", "poe"]
     */

    public String[] solution(String[] players, String[] callings) {
        int playersSize = players.length;

        int callingsSize = callings.length;

        HashMap<String,Integer> rankMap = new HashMap<>();

        int count = 1;
        for(int i=0; i<playersSize;i++) {
            rankMap.put(players[i],count);
            count++;
        }

        for(int j=0; j<callingsSize; j++) {
            String target = callings[j];
            int targetRank = rankMap.get(target).intValue();

            if(targetRank==1) break;
            //타겟이전
            String swap = players[targetRank-2];
            rankMap.put(swap,targetRank);
            players[targetRank-2] = target;

            //타겟
            rankMap.put(target,targetRank-1);
            players[targetRank-1] = swap;

        }
        return players;
    }

    public static void main(String[] args) throws IOException {
        Solution_2 main = new Solution_2();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        main.solution(players,callings);
    }
}
