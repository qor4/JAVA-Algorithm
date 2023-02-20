import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int cnt, r, c;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		solve(0, 0, (int) Math.pow(2, N));
		bw.flush();
		bw.close();
	}

	private static void solve(int start, int end, int size) throws IOException {
		if (start == r && end == c) {
			bw.write(cnt + "");
			return;
		}
		if (size == 0)
			return;

		int half = size / 2;
		if (start + half > r && end + half > c) {
			solve(start, end, half);
		} else if (start + half > r && end + half <= c) {
			cnt += half * half;
			solve(start, end + half, half);
		} else if (start + half <= r && end + half > c) {
			cnt += half * half * 2;
			solve(start + half, end, half);
		} else if (start + half <= r && end + half <= c) {
			cnt += half * half * 3;
			solve(start + half, end + half, half);
		}
		return;
	}

}
