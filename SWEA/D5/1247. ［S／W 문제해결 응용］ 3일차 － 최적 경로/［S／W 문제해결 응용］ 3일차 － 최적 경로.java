
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] arr, orders;
	static int N, min;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 2][2];
			orders = new int[N][2];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N + 2; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			perm(0);
			bw.write("#" + tc + " " + min + "\n");
		}
		bw.flush();
		bw.close();

	}

	private static void perm(int cnt) {
		if (cnt == N) {
			int distance = 0;
			int[] loc = arr[0];
			for (int i = 0; i < N; i++) {
				distance += Math.abs(loc[0] - orders[i][0]) + Math.abs(loc[1] - orders[i][1]);
				loc = orders[i];
			}
			distance += Math.abs(loc[0] - arr[1][0]) + Math.abs(loc[1] - arr[1][1]);
			min = Math.min(min, distance);
			return;
		}
		for (int i = 2; i < N + 2; i++) {
			if (visited[i - 2])
				continue;
			visited[i - 2] = true;
			orders[cnt] = arr[i];
			perm(cnt + 1);
			visited[i - 2] = false;
		}
	}
}
