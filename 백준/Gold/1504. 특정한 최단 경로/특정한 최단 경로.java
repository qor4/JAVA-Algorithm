import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
            graph[b][a] = c;
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int case1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int case2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        if((case1 >= 987654321 || case1 < 0) && (case2 >= 987654321 || case2 < 0)) System.out.println(-1);
        else System.out.println(Math.min(case1, case2));

    }

    private static int dijkstra(int start, int end) {
        int[] costs = new int[N + 1];
        Arrays.fill(costs, 987654321);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});
        costs[start] = 0;

        while(!pq.isEmpty()){
            int[] v = pq.poll();
            int n = v[0];
            int cost = v[1];

            for(int i = 1; i <= N; i++){
                if(graph[n][i] == 0) continue;
                if(costs[i] > cost + graph[n][i]){
                    costs[i] = cost + graph[n][i];
                    pq.add(new int[]{i, costs[i]});
                }
            }
        }
        return costs[end];
    }
}
