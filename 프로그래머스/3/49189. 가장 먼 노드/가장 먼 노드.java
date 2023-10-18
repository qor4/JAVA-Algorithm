import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int[] count;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        count = new int[n + 1];
        graph = new List[n + 1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        bfs();
        System.out.println(Arrays.toString(count));
        Arrays.sort(count);
        for(int i = count.length - 1; i > 0; i--){
            if(count[count.length - 1] == count[i]) answer++;
            else break;
        }        
        return answer;
    }
    
    public void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length + 1];
        queue.add(new int[]{1, 0});
        visited[1] = true;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int num = node[0];
            int cnt = node[1];
            for(Integer nextNode : graph[num]){
                if(visited[nextNode]) continue;
                count[nextNode] = Math.max(count[nextNode], cnt + 1);
                queue.add(new int[]{nextNode, cnt + 1});
                visited[nextNode] = true;
            }
        }
    }
}