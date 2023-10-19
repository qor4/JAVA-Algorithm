import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] count = new int[n][m];
        
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{-1, 1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        count[0][0] = 1;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int cnt = node[2]; 
            if(x == n - 1 && y == m - 1) break;
            for(int i = 0; i < 4; i++){
                if(x + dx[i] < 0 || x + dx[i] >= n ||
                   y + dy[i] < 0 || y + dy[i] >= m ||
                   count[x + dx[i]][y + dy[i]] != 0 || maps[x + dx[i]][y + dy[i]] == 0 ) continue;
                queue.add(new int[]{x + dx[i], y + dy[i], cnt + 1});
                count[x + dx[i]][y + dy[i]] = cnt + 1;
            }
        }
        return count[n - 1][m - 1] == 0 ? -1 : count[n - 1][m - 1];
    }
}