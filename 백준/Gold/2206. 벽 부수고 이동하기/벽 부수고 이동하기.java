import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int M;
    static int answer;
    static int[][] map;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        answer = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        findDistance();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void findDistance() {
        int[][][] distance = new int[N][M][2];
        distance[0][0][0] = 1;
        distance[0][0][1] = 1;
//        distance[N-1][M-1][0] = Integer.MAX_VALUE;
//        distance[N-1][M-1][1] = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int dis = tmp[2];
            int isBreak = tmp[3];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;


                
                if(map[nx][ny] == 1 && isBreak == 0 && distance[nx][ny][1] == 0){ // 다음 위치가 벽이면서 이때까지 벽을 부순적이 없다면if(isBreak == 0) { // 벽을 부순적이 없으면서 다음이 벽이라면
                    distance[nx][ny][1] = dis + 1;
                    queue.add(new int[]{nx, ny, dis + 1, 1}); // isBreak를 1로 변경 -> 벽을 부숨
                }
                if(map[nx][ny] == 0 && distance[nx][ny][isBreak] == 0){
                    distance[nx][ny][isBreak] = dis + 1;
                    queue.add(new int[]{nx, ny, dis + 1, isBreak});
                }
            }
        }
       
        answer = Math.min(answer, Math.min(distance[N-1][M-1][0] == 0 ? Integer.MAX_VALUE : distance[N-1][M-1][0], distance[N-1][M-1][1] == 0 ? Integer.MAX_VALUE : distance[N-1][M-1][1]));
    }
}
