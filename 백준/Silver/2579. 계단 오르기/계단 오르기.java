import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N+3];
		int[] dp = new int[N+3];
		for (int i = 0; i < N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = stair[0];
		dp[1] = stair[0] + stair[1];
		dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(stair[i - 1] + dp[i - 3], dp[i - 2]) + stair[i];
		}
		bw.write(dp[N - 1] + "");
		bw.flush();
		bw.close();
	}

}
