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

		for (int i = 0; i < (N / 3) + 1; i++) {
			if ((N - (3 * i)) % 5 == 0) {
				bw.write((i + (N - (3 * i)) / 5) + "");
				break;
			}
			if ((N - (3 * i)) < 3) {
				bw.write(-1 + "");
				break;
			}
		}

		bw.flush();
		bw.close();

	}
}