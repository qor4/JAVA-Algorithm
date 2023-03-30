import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 가로 : 2, 세로 : 3, 대각선 : 4
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		List<Integer>[][] dp = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = new ArrayList<>();
			}
		}

		// 가로일 때, 가로, 대각선만
		// 세로일 때 세로, 대각선만
		// 대각선일 때, 가로, 세로, 대각선
		int[][] dir = new int[][] { {}, {}, { 2, 4 }, { 3, 4 }, { 2, 3, 4 } };
		int[][] dx = new int[][] { {}, {}, { 1, 1 }, { 0, 0 }, { 1, 1, 0, 1 } };
		int[][] dy = new int[][] { {}, {}, { 0, 0 }, { 1, 1 }, { 0, 1, 1, 1 } };

		dp[0][1].add(2);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (Integer p : dp[i][j]) {
					for (int d : dir[p]) {
						boolean flag = true;
						for (int k = 0; k < dx[d].length - 1; k++) {
							if (i + dy[d][k] >= N || j + dx[d][k] >= N || map[i + dy[d][k]][j + dx[d][k]] == 1) {
								flag = false;
								break;
							}
						}
						if (flag) {
							dp[i + dy[d][dx[d].length - 1]][j + dx[d][dx[d].length - 1]].add(d);
						}
					}
				}
			}
		}

		bw.write(dp[N - 1][N - 1].size() + "");
		bw.flush();
		bw.close();
	}

}
