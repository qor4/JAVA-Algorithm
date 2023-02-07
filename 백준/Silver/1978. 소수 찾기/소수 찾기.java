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

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 2)
				cnt++;
			for (int j = 2; j < Math.sqrt(num) + 1; j++) {
				if (num % j == 0)
					break;
				if (j + 1 >= Math.sqrt(num) + 1)
					cnt++;
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}
