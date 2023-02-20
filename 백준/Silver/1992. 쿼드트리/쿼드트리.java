import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static String[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		int N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}
		solve(0, 0, N);
		bw.flush();
		bw.close();
	}

	private static void solve(int start, int end, int size) throws IOException {

		int cnt = 0;
		for (int i = start; i < start + size; i++) {
			for (int j = end; j < end + size; j++) {
				cnt += Integer.parseInt(map[i][j]);
			}
		}
		if (cnt == 0) {
			bw.write(0 + "");
			return;
		}
		if (cnt == size * size) {
			bw.write(1 + "");
			return;
		}

		bw.write("(");
		int half = size / 2;
		solve(start, end, half);
		solve(start, end + half, half);
		solve(start + half, end, half);
		solve(start + half, end + half, half);
		bw.write(")");
		return;
	}

}
