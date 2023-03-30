import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] cost = new int[N][2];
		int[][] dp = new int[N + 1][K + 1];
		Arrays.fill(dp[0], 0);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				if (j - cost[i - 1][0] >= 0)
					dp[i][j] = Math.max(dp[i - 1][j], cost[i - 1][1] + dp[i - 1][j - cost[i - 1][0]]);
				else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		bw.write(dp[N][K] + "");
		bw.flush();
		bw.close();
	}

}
