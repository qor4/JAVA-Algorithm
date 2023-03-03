
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int[][] Pdir = new int[][] { { 1, 2, 5, 6 }, { 1, 2, 4, 7 }, { 1, 3, 4, 5 }, { 1, 3, 6, 7 } };
		int[][] pipeType = new int[][] { null, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 },
				{ 0, 2 } };

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<Integer[]> q = new LinkedList<>();
			q.add(new Integer[] { R, C, 1 });
			int ans = 1;
			visited[R][C] = true;
			while (!q.isEmpty()) {
				Integer[] p = q.poll();
				int x = p[0];
				int y = p[1];
				int pipe = map[x][y];

				if (p[2] == L)
					continue;
				for (int i : pipeType[pipe]) {
					int[] d = dir[i];
					boolean flag = false;
					if (x + d[0] < 0 || x + d[0] >= N || y + d[1] < 0 || y + d[1] >= M || map[x + d[0]][y + d[1]] == 0
							|| visited[x + d[0]][y + d[1]])
						continue;
					for (int t : Pdir[i]) {
						if (map[x + d[0]][y + d[1]] == t) {
							flag = true;
							break;
						}
					}
					if (flag) {
						q.add(new Integer[] { x + d[0], y + d[1], p[2] + 1 });
						visited[x + d[0]][y + d[1]] = true;
						ans++;
					}
				}
			}
			bw.write("#" + tc + " " + ans + "\n");

		}
		bw.flush();
		bw.close();
	}
}
