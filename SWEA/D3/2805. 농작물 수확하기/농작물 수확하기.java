import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			int left = (int) Math.floor(N / 2.0);
			int right = (int) Math.floor(N / 2.0);
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = left; j <= right; j++) {
					sum += arr[i][j];
				}
				if (i < (int) Math.floor(N / 2.0)) {
					left--;
					right++;
				} else {
					left++;
					right--;
				}
			}
			bw.write("#" + tc + " " + sum + "\n");

		}
		bw.flush();
		bw.close();
	}
}
