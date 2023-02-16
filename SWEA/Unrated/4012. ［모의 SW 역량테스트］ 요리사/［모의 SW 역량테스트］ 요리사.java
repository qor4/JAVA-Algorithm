
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, min;
	static int[][] arr;
	static int[] numbers, input;
	static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			arr = new int[N][N];
			numbers = new int[N / 2];
			input = new int[N];
			selected = new boolean[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				input[i] = i;
			}
			comb(0, 0);
			bw.write("#" + tc + " " + min + "\n");
		}
		bw.flush();
		bw.close();

	}

	private static void comb(int cnt, int start) {
		// TODO Auto-generated method stub
		if (cnt == N / 2) {
			int[] numbers2 = new int[N / 2];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (!selected[i])
					numbers2[idx++] = i;
			}
			int cnt1 = 0;
			int cnt2 = 0;
			for (int i : numbers) {
				for (int j : numbers) {
					cnt1 += arr[i][j];

				}
			}
			for (int i : numbers2) {
				for (int j : numbers2) {
					cnt2 += arr[i][j];

				}
			}
			min = Math.min(min, Math.abs(cnt1 - cnt2));
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			selected[i] = true;
			comb(cnt + 1, i + 1);
			selected[i] = false;
		}
	}

}
