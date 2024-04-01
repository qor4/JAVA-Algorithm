import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] times;
    static boolean[][] visited;
    static Queue<int[]> hedgehog;
    static Queue<int[]> water;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        times = new int[R][C];
        visited = new boolean[R][C];

        water = new LinkedList<>();
        hedgehog = new LinkedList<>();

        int goalX = 0, goalY = 0;
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'D') {
                    goalX = i;
                    goalY = j;
                } else if (map[i][j] == '*') {
                    water.add(new int[]{i, j, 0});
                } else if (map[i][j] == 'S') {
                    hedgehog.add(new int[]{i, j, 0});
                    map[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < R; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }
        water();
        for (int i = 0; i < R; i++) {
            Arrays.fill(visited[i], false);
        }
        bfs();

        if (times[goalX][goalY] == Integer.MAX_VALUE) System.out.println("KAKTUS");
        else System.out.println(times[goalX][goalY]);
    }

    private static void water() {
        if(!water.isEmpty()){
            visited[water.peek()[0]][water.peek()[1]] = true;
        }
        while (!water.isEmpty()) {
            int[] cur = water.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || map[nx][ny] ==
                        'X') continue;

                if (map[nx][ny] == '.') {
                    times[nx][ny] = time + 1;
                    visited[nx][ny] = true;
                    water.add(new int[]{nx, ny, time + 1});
                }
            }
        }
    }

    private static void bfs() {
        visited[hedgehog.peek()[0]][hedgehog.peek()[1]] = true;
        while (!hedgehog.isEmpty()) {
            int[] cur = hedgehog.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];

            if (map[x][y] == 'D') {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || map[nx][ny] ==
                        'X') continue;

                if (map[nx][ny] != '*' && map[nx][ny] != 'X' && time + 1 < times[nx][ny]) {
                    hedgehog.add(new int[]{nx, ny, time + 1});
                    times[nx][ny] = time + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
