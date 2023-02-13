import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = N - 1;
			boolean state = true;
			while (left <= right) {

				if (A[left + ((right - left) / 2)] == num) {
					bw.write(1 + "\n");
					state = false;
					break;
				} else if (A[left + ((right - left) / 2)] > num) {
					right = left + ((right - left) / 2) - 1;

				} else {
					left = left + ((right - left) / 2) + 1;
				}
			}
			if (state)
				bw.write(0 + "\n");

		}
		bw.flush();
		bw.close();

	}
}