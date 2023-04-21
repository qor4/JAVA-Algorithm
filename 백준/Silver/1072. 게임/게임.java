import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long odds = 100 * Y / X;

		if (odds >= 99) {
			System.out.println(-1);
			return;
		}

		long start = 0;
		long end = X;
		while (start < end) {
			long mid = (start + end) / 2;
			if (100 * (Y + mid) / (X + mid) > odds) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		bw.write(end + "");
		bw.flush();
		bw.close();
	}
}