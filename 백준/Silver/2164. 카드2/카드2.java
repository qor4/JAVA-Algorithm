import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		if (N == 1)
			bw.write(1 + "");
		else if (N == 2)
			bw.write(2 + "");
		else {
			int num = 2;
			for (int i = 0; i < N; i++) {
				if (num * 2 > N) {
					bw.write(((N - num) * 2) + "");
					break;
				} else if (num * 2 == N) {
					bw.write(N + "");
					break;

				}
				num *= 2;
			}
		}

		bw.flush();
		bw.close();

	}
}