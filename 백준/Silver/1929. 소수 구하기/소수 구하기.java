import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] dp = new boolean[N + 1];
		dp[1] = true;
		for (int i = 2; i <= N; i++) {
			if (dp[i])
				continue;
			for (int j = i + i; j <= N; j += i) {
				dp[j] = true;
			}
		}
		for (int i = M; i <= N; i++) {
			if (dp[i])
				continue;
			bw.write(i + "\n");

		}
		bw.flush();
		bw.close();

	}
}