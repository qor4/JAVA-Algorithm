import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int cnt, N;
	static char[][] map;
	static boolean[][] visited;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		visited = new boolean[N][N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j])
					cnt++;
					dfs(i, j);
			}
		}

		bw.write(cnt + " ");
		visited = new boolean[N][N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j])
					cnt++;
					dfs(i, j);
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
		for (int[] d : dir) {
			if (x + d[0] < 0 || x + d[0] >= N || y + d[1] < 0 || y + d[1] >= N)
				continue;
			if (map[x + d[0]][y + d[1]] == map[x][y] && !visited[x + d[0]][y + d[1]]) {
				dfs(x + d[0], y + d[1]);
			}
		}

	}

}
