import java.time.temporal.ChronoField;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static boolean[][][] visited;
    static int answer;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][64];
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            char[] mapArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = mapArr[j];
                if (map[i][j] == '0') {
                    queue.add(new int[]{i, j, 0, 0});
                    map[i][j] = '.';
                    visited[i][j][0] = true;
                }
            }
        }

        answer = Integer.MAX_VALUE;
        bfs();
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            int keys = cur[3];
            if (map[x][y] == '1') {
                System.out.println(cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#' || visited[nx][ny][keys]) continue;

                if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
                    int newKeys = keys | (1 << map[nx][ny] - 'a');
                    queue.add(new int[]{nx, ny, cnt + 1, newKeys});
                    visited[nx][ny][newKeys] = true;
                } else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
                    if ((keys & (1 << map[nx][ny] - 'A')) != 0) {
                        queue.add(new int[]{nx, ny, cnt + 1, keys});
                        visited[nx][ny][keys] = true;
                    }
                } else {
                    queue.add(new int[]{nx, ny, cnt + 1, keys});
                    visited[nx][ny][keys] = true;
                }
            }
        }
        System.out.println(-1);
    }

}