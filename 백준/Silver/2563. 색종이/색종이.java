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
		int[][] arr = new int[101][101];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {

					arr[x + j][y + k] = 1;
				}
			}

		}
		int cnt = 0;
		for (int j = 0; j < 101; j++) {
			for (int k = 0; k < 101; k++) {
				if (arr[j][k] == 1) {
					cnt++;
				}
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}
