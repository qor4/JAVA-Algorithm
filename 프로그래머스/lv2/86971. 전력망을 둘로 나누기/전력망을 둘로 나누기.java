import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++){
            boolean[] visited = new boolean[n+1];
            List[] graph = new List[n+1];
            for(int j = 1; j <= n; j++){
                graph[j] = new ArrayList<>();
            }
            Stack<Integer> stack = new Stack<>();
            
            for(int j = 0; j < wires.length; j++){
                if(i == j) continue;
                graph[wires[j][0]].add(wires[j][1]);
                graph[wires[j][1]].add(wires[j][0]);
            }

            int[] count = new int[2];
            boolean flag = true;
            for(int j = 1; j <= n; j++){
                if(visited[j]) continue;
                int cnt = 0;
                stack.push(j);
                while(!stack.isEmpty()){
                    int node = stack.pop();
                    cnt++;
                    visited[node] = true;
                    
                    for(int k = 0; k < graph[node].size(); k++){
                        Integer num = (Integer)graph[node].get(k);
                        if(visited[num]) continue;
                        stack.push(num);
                    } 
                }
                if(flag) {
                    count[0] = cnt;
                    flag = false;
                }
                else count[1] = cnt;
            }
            answer = Math.min(answer, Math.abs(count[0] - count[1]));
        }
        return answer;
    }
}