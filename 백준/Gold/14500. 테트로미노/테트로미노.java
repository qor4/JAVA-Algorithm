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

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int max = -1;
		int[][] poly_x = { { 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 1, 2, 0 },
				{ 0, 1, 1, 1 }, { 0, 0, -1, -2 }, { 0, 0, 1, 1 }, { 0, 1, 1, 2 }, { 0, 1, 1, 2 }, { 0, 1, 1, 2 },
				{ 0, 0, 0, 1 }, { 0, 0, 0, -1 }, { 0, 0, 0, -1 }, { 0, 0, 1, 2 }, { 0, 1, 0, 0 }, { 0, 1, 2, 2 },
				{ 0, 0, 1, 1 }, { 0, 1, 1, 2 } };
		int[][] poly_y = { { 0, 1, 2, 3 }, { 0, 0, 0, 0 }, { 0, 0, 1, 1 }, { 0, 1, 2, 2 }, { 0, 0, 0, 1 },
				{ 0, 0, 1, 2 }, { 0, 1, 1, 1 }, { 0, 1, 1, 2 }, { 0, 0, -1, -1 }, { 0, 0, 1, 0 }, { 0, 0, -1, 0 },
				{ 0, 1, 2, 1 }, { 0, 1, 2, 1 }, { 0, 1, 2, 2 }, { 0, 1, 1, 1 }, { 0, 0, 1, 2 }, { 0, 0, 0, 1 },
				{ 0, -1, -1, -2 }, { 0, 0, 1, 1 } };
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < poly_x.length; k++) {
					int cnt = 0;
					for (int l = 0; l < 4; l++) {
						if (i + poly_y[k][l] < 0 || i + poly_y[k][l] >= N || j + poly_x[k][l] < 0
								|| j + poly_x[k][l] >= M) {
							cnt = -1;
							break;
						}
						cnt += map[i + poly_y[k][l]][j + poly_x[k][l]];
					}
					max = Math.max(max, cnt);
				}
			}
		}
		bw.write(max + "");

		bw.flush();
		bw.close();
	}
}