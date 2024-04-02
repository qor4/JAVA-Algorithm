import java.time.temporal.ChronoField;
import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        int[] plan = new int[M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        boolean flag = true;
        for (int i = 0; i < M - 1; i++) {
            if (!dfs(plan[i], plan[i + 1])) {
                flag = false;
                break;
            }
        }
        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean dfs(int start, int end) {
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (cur == end) return true;

            for (int i = 0; i < N; i++) {
                if (adj[cur][i] == 1 && !visited[i]) {
                    stack.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }


}