import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			if(N==1) {
				bw.write(1 + "\n");
				continue;
			}
			long[] arr = new long[N + 1];
			arr[0] = 0;
			arr[1] = 1;
			arr[2] = 1;
			for (int i = 3; i <= N; i++) {
				arr[i] = arr[i - 2] + arr[i - 3];
			}

			bw.write(arr[N] + "\n");
		}
		bw.flush();
		bw.close();
	}

}