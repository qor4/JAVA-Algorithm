import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long ans = N;
		for (int i = 0; i < N; i++) {
			arr[i] -= B;
			ans += Math.ceil(arr[i] * 1.0 / C) > 0 ? Math.ceil(arr[i] * 1.0 / C) : 0;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}

}
