import java.util.*;

class Solution {
    static int n, answer;
    static int[][] dungeon;
    static int[] order;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        dungeon = dungeons;
        n = dungeons.length;
        visited = new boolean[n];
        order = new int[n];
        perm(0, k);
        return answer;
    }
    
    public static void perm(int cnt, int k){
        if(cnt == n){
            int count = 0;
            for(int i = 0; i < order.length; i++){
                if(dungeon[order[i]][0] > k) break;
                k -= dungeon[order[i]][1];
                count++;
            }
            answer = Math.max(count, answer);
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            order[cnt] = i;
            perm(cnt + 1, k);
            visited[i] = false;
        }
    }
}