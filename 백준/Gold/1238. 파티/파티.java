import java.util.*;
import java.io.*;

public class Main {
    static int N, X;
    static int answer;
    static int[][] arr;
    static int[][] cost;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        cost = new int[N + 1][N + 1];
        answer = -1;
        for(int i = 1; i <= N; i++){
            Arrays.fill(cost[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[s][e] = t;
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer,  cost[i][X] + cost[X][i]);
        }
        System.out.println(answer);
    }

    private static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, start});
        cost[start][start] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[cur[1]][i] == 0 || i == start) continue;
                if (cost[start][i] > cur[0] + arr[cur[1]][i]) {
                    cost[start][i] = cur[0] + arr[cur[1]][i];
                    pq.add(new int[]{cost[start][i], i});
                }
            }
        }
    }
}
