import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int min = 1000000000;
	static int[][] flavor;
	static boolean[] selected;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());

		flavor = new int[N][2];
		selected = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			flavor[i][0] = Integer.parseInt(st.nextToken());
			flavor[i][1] = Integer.parseInt(st.nextToken());
		}

		subset(0);
		bw.write(min + "");
		bw.flush();
		bw.close();
	}

	private static void subset(int cnt) {
		if (cnt == N) {
			int sum = 0;
			int mul = 1;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					mul = mul * flavor[i][0];
					sum = sum + flavor[i][1];
				}
			}
			if (Math.abs(mul - sum) < min && sum != 0) {
				min = Math.abs(mul - sum);
			}

			return;
		}
		selected[cnt] = true;
		subset(cnt + 1);
		selected[cnt] = false;
		subset(cnt + 1);
	}
}
