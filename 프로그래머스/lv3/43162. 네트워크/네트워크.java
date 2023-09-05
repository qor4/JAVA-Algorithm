import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 리스트 배열 생성
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1) graph[i].add(j);
            }
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            stack.add(i);
            while(!stack.isEmpty()){
                int node = stack.pop();
                visited[node] = true;
                for(int j = 0; j < graph[node].size(); j++){
                    if(visited[graph[node].get(j)]) continue;
                    stack.add(graph[node].get(j));
                }
            }
            answer++;
        }
        
        return answer;
    }
}