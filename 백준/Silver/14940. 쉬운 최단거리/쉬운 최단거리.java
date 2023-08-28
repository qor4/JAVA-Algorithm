import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] answer = new int[N][M];
        int[] start = new int[2];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    start = new int[]{i, j};
                    visited[i][j] = true;
                }
            }
        }
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = node[0] + dx[i];
                int newY = node[1] + dy[i];
                if (newX >= N || newX < 0 || newY >= M || newY < 0 || visited[newX][newY] || arr[newX][newY] == 0) {
                    continue;
                }
                queue.add(new int[]{newX, newY});
                answer[newX][newY] = answer[node[0]][node[1]] + 1;
                visited[newX][newY] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] != 0 && answer[i][j] == 0) {
                    answer[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(answer[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
