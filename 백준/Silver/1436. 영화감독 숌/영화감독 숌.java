import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		int title = 665;
		while (cnt < N) {
			title++;
			if (Integer.toString(title).contains("666")) {
				cnt++;
			}
		}
		bw.write(title + "");
		bw.flush();
		bw.close();
	}
}
