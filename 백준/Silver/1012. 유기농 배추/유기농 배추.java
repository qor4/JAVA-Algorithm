import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int tc = 0; tc < T; tc++) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			Queue<Integer[]> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						ans++;
						q.offer(new Integer[] { i, j });
						map[i][j] = 0;
						while (!q.isEmpty()) {
							Integer[] pos = q.poll();
							for (int[] d : dir) {
								if (pos[0] + d[0] < 0 || pos[0] + d[0] >= N || pos[1] + d[1] < 0 || pos[1] + d[1] >= M)
									continue;
								if (map[pos[0] + d[0]][pos[1] + d[1]] == 1) {
									q.offer(new Integer[] { pos[0] + d[0], pos[1] + d[1] });
									map[pos[0] + d[0]][pos[1] + d[1]] = 0;
								}
							}
						}
					}
				}
			}
			bw.write(ans + "\n");
		}

		bw.flush();
		bw.close();
	}

}