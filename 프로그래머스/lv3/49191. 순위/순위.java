// 플로이드 워셜 알고리즘
import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n + 1][n + 1];
        for(int i = 0; i < results.length; i++){
            int A = results[i][0];
            int B = results[i][1];
            map[A][B] = 1; // A가 B를 이김
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(map[k][i] == 1 && map[i][j] == 1){
                        map[k][j] = 1;
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= n; j++){
                if(map[i][j] == 1) count++;
                if(map[j][i] == 1) count++;
            }
            if(count == n-1) answer++;
        }
        return answer;
    }
}