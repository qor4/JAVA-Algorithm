import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Vertex {
	int x;
	int y;
	int c;

	public Vertex(int x, int y, int c) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
	}
}

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
				String[] tmp = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}

			int[][] dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
			dp[0][0] = 0;

			Queue<Vertex> q = new LinkedList<>();
			q.add(new Vertex(0, 0, map[0][0]));

			while (!q.isEmpty()) {
				Vertex v = q.poll();
				for (int[] d : dir) {
					if (v.x + d[0] >= N || v.x + d[0] < 0 || v.y + d[1] >= N || v.y + d[1] < 0)
						continue;
					if (dp[v.x][v.y] + map[v.x + d[0]][v.y + d[1]] < dp[v.x + d[0]][v.y + d[1]]) {
						dp[v.x + d[0]][v.y + d[1]] = dp[v.x][v.y] + map[v.x + d[0]][v.y + d[1]];
						q.add(new Vertex(v.x + d[0], v.y + d[1], dp[v.x + d[0]][v.y + d[1]]));

					}
				}
			}

			bw.write("#" + tc + " " + dp[N - 1][N - 1] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
