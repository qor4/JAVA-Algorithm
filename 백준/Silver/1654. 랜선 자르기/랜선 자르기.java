import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] lans = new int[K];


		for (int i = 0; i < K; i++) {
			lans[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(lans);
		long e = lans[lans.length-1];
		long s = 1;
		long max = 0;
		while (s <= e) {
			long ans = 0;
			long mid = ((e + s) / 2);
			for (int lan : lans) {
				ans += lan / mid;
			}
			if (ans < N)
				e = mid - 1;
			else {
				s = mid + 1;
				max = Math.max(max, mid);
			}
		}
		bw.write(e + "");
		bw.flush();
		bw.close();

	}
}