import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static int[] costs;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = 100000001;
            }
        }
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], cost);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(costs[end]);
    }

    private static void dijkstra(int start) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, start});
        costs[start] = 0;

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int n = node[1];
            int cost = node[0];

            if(visited[n]) continue;

            visited[n] = true;
            for(int i = 1; i <= N; i++){
                if(costs[i] > cost + graph[n][i]){
                    costs[i] = cost + graph[n][i];
                    pq.add(new int[]{costs[i], i});
                }
            }
        }
    }
}
