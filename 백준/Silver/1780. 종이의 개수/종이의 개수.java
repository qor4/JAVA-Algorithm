import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		answer = new int[3];
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0, N);

		bw.write(answer[0] + "\n" + answer[1] + "\n" + answer[2]);
		bw.flush();
		bw.close();
	}

	private static void solve(int x, int y, int size) {
		int mark = map[x][y];
		boolean flag = true;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (mark != map[i][j]) {
					flag = false;
					break;
				}
			}
		}
		if (flag && mark == -1) {
			answer[0]++;
			return;
		} else if (flag && mark == 0) {
			answer[1]++;
			return;
		} else if (flag && mark == 1) {
			answer[2]++;
			return;
		}
		int n = size / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				solve(x + (n * i), y + (n * j), n);
			}
		}

	}
}