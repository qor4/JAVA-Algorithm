import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] map, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], -1);
		}

		bw.write(dfs(0, 0) + "");
		bw.flush();
		bw.close();
	}

	private static int dfs(int x, int y) {
		if(dp[x][y] != -1) return dp[x][y];
		if (x == M - 1 && y == N - 1) {
			return 1;
		}
		int cnt = 0;
		for (int[] d : dir) {
			if (x + d[0] < 0 || x + d[0] >= M || y + d[1] < 0 || y + d[1] >= N || map[x + d[0]][y + d[1]] >= map[x][y])
				continue;
			cnt += dfs(x + d[0], y + d[1]);
		}
		return dp[x][y] =cnt;
	}
}
