
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int[] priceArr = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				priceArr[i] = Integer.parseInt(st.nextToken());
			}
			int[] month = new int[13];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < 13; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			int[] dp = new int[13];
			dp[0] = 0;
			dp[1] = Math.min(priceArr[0] * month[1], Math.min(priceArr[1], priceArr[2]));
			dp[2] = Math.min(dp[1] + priceArr[0] * month[2], Math.min(dp[1] + priceArr[1], priceArr[2]));
			dp[3] = Math.min(dp[2] + priceArr[0] * month[3], Math.min(dp[2] + priceArr[1], priceArr[2]));
			for (int i = 4; i < 13; i++) {
				dp[i] = Math.min(dp[i - 1] + priceArr[0] * month[i],
						Math.min(dp[i - 1] + priceArr[1], dp[i - 3] + priceArr[2]));
			}

			bw.write("#" + tc + " " + Math.min(dp[12], priceArr[3]));

			bw.write("\n");

		}
		bw.flush();
		bw.close();
	}
}
