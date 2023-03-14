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
		long[] dp = new long[N + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < N + 1; i++) {
			dp[i] = (dp[i - 1] + (dp[i - 2]*2)) % 10007;
		}

		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
	}

}