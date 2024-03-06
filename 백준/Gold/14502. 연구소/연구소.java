import java.util.*;
import java.io.*;


public class Main {
    static int N, M, answer;
    static int[][] map, tempMap;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        answer = Integer.MIN_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        copyMap();
        buildWall(0);
        System.out.println(answer);
    }

    private static void copyMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
    }

    private static void buildWall(int cnt) {
        if (cnt == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    tempMap[i][j] = 1;
                    buildWall(cnt + 1);
                    tempMap[i][j] = 0;
                }
            }
        }
    }


    private static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] virusMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = tempMap[i][j];
                if (virusMap[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];

                if (nx >= N || nx < 0 || ny >= M || ny < 0 || virusMap[nx][ny] != 0) continue;
                virusMap[nx][ny] = 2;
                queue.add(new int[]{nx, ny});
            }
        }

        answer = Math.max(answer, calEmpty(virusMap));
    }

    private static int calEmpty(int[][] virusMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
