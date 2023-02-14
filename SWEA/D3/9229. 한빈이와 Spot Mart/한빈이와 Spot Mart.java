
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int[] input;
	static int[] numbers = new int[2];
	static int N, M, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			input = new int[N];
			max = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			comb(0, 0);
			if(max != 0) bw.write("#" + tc + " " + max + "\n");
			else bw.write("#" + tc + " -1\n");
		}
		bw.flush();
		bw.close();
	}

	private static void comb(int cnt, int start) {
		if (cnt == 2) {
			int num = numbers[0] + numbers[1];
			if (num <= M && num > max)
				max = num;
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}

	}
}
