import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int[][] costs = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					int[] arr = Arrays.copyOfRange(map[i], j, j + M);
					Arrays.sort(arr);

					int maxCost = 0;
					for (int k = 0; k < 1 << M; k++) {
						int sum = 0;
						int cost = 0;
						for (int l = 0; l < M; l++) {
							if ((k & 1 << l) != 0) {
								sum += arr[l];
								cost += arr[l] * arr[l];
							}
						}
						if (sum > C)
							continue;
						maxCost = Math.max(maxCost, cost);
					}
					costs[i][j] = maxCost;
				}
			}

			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = j + M; k < N; k++) {
						max = Math.max(costs[i][j] + costs[i][k], max);
					}
					for (int k = i + 1; k < N; k++) {
						for (int l = 0; l < N; l++) {
							max = Math.max(costs[i][j] + costs[k][l], max);
						}
					}
				}
			}
			bw.write("#" + tc + " " + max + "\n");
		}
		bw.flush();
		bw.close();
	}
}
