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
		int color[][] = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if (k == j)
						continue;
					min = Math.min(min, color[i - 1][k]);
				}
				color[i][j] = min + color[i][j];
			}
		}

		bw.write(Math.min(Math.min(color[N][0], color[N][1]), color[N][2]) + "");
		bw.flush();
		bw.close();
	}
}
