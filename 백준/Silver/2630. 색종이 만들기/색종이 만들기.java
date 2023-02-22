import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	static int[] answer;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		answer = new int[2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0, 0, N);
		bw.write(answer[0] + "\n" + answer[1]);
		bw.flush();
		bw.close();
	}

	private static void solve(int start, int end, int size) {
		int sum = 0;
		for (int i = start; i < start + size; i++) {
			for (int j = end; j < end + size; j++) {
				sum += map[i][j];
			}
		}
		if (sum == 0) {
			answer[0]++;
			return;
		} else if (sum == size * size) {
			answer[1]++;
			return;
		}
		int half = size / 2;
		solve(start, end, half);
		solve(start + half, end, half);
		solve(start, end + half, half);
		solve(start + half, end + half, half);

	}
}