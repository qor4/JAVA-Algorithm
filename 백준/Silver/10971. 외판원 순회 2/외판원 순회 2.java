import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, min;
	static int[][] cost;
	static int[] numbers;
	static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		numbers = new int[N + 1];
		selected = new boolean[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(0);
		bw.write(min + "");
		bw.flush();
		bw.close();
	}

	private static void perm(int cnt) {
		if (cnt == N) {
			int sum = 0;
			int start = numbers[0];
			numbers[N] = start;
			for (int i = 0; i < N; i++) {
				if (cost[numbers[i]][numbers[i + 1]] == 0) {
					sum = Integer.MAX_VALUE;
					break;
				}
				sum += cost[numbers[i]][numbers[i + 1]];
			}
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (selected[i])
				continue;
			selected[i] = true;
			numbers[cnt] = i;
			perm(cnt + 1);
			selected[i] = false;
		}
	}
}
