import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] contains = new int[d + 1];
		contains[c] = 1;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int ans = 1;
		for (int i = 0; i < k; i++) {
			if (contains[arr[i % N]] == 0) {
				ans++;
			}
			contains[arr[i % N]]++;
		}
		int cnt = ans;
		for (int i = k; i < N + k; i++) {
			contains[arr[(i - k) % N]]--;
			if (contains[arr[(i - k) % N]] == 0)
				cnt--;
			if (contains[arr[i % N]] == 0) {
				cnt++;
			}
			contains[arr[i % N]]++;
			ans = Math.max(ans, cnt);
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
