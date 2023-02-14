import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] numbers;
	static int N, M, R;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		numbers = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		turn(0, 0, N - 1, M - 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(numbers[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static void turn(int sR, int sC, int eR, int eC) throws IOException {
		if (sR >= eR || sC >= eC) {
			return;
		}
		for (int r = 0; r < R; r++) {

			int temp = numbers[sR][sC];

			for (int i = sC; i < eC; i++) {
				numbers[sR][i] = numbers[sR][i + 1];
			}
			for (int i = sR; i < eR; i++) {
				numbers[i][eC] = numbers[i + 1][eC];
			}

			for (int i = eC; i > sC; i--) {
				numbers[eR][i] = numbers[eR][i - 1];
			}

			for (int i = eR; i > sR+1; i--) {
				numbers[i][sC] = numbers[i - 1][sC];
			}

			numbers[sR + 1][sC] = temp;

		}

		turn(sR + 1, sC + 1, eR - 1, eC - 1);
	}

}
