import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N + 1];

			if (N < 3) {
				bw.write(N + "\n");
				continue;
			}
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <= N; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
			bw.write(dp[N] + "\n");
		}
		bw.flush();
		bw.close();
	}
}