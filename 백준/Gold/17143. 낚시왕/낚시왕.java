import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Shark {
	int[][] dir = new int[][] { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	int s;
	int[] d;
	int z;

	public Shark(int s, int d, int z) {
		super();
		this.s = s;
		this.d = dir[d];
		this.z = z;
	}

}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Shark[][] matrix = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if (d == 1 || d == 2)
				s = s % ((R - 1) * 2);
			else if (d == 3 || d == 4)
				s = s % ((C - 1) * 2);
			matrix[r][c] = new Shark(s, d, z);
		}

		int weight = 0;

		for (int p = 1; p <= C; p++) {
			// 1. 상어를 잡음
			for (int i = 1; i <= R; i++) {
				if (matrix[i][p] != null) {
					// 잡은 상어 무게 합산
					weight += matrix[i][p].z;
					matrix[i][p] = null;
					break;
				}
			}
			// 2. 상어 이동
			Shark[][] tmp = new Shark[R + 1][C + 1];
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (matrix[i][j] == null)
						continue;
					int x = i;
					int y = j;

					for (int s = 0; s < matrix[i][j].s; s++) {
						if (x + matrix[i][j].d[0] > R || x + matrix[i][j].d[0] < 1 || y + matrix[i][j].d[1] > C
								|| y + matrix[i][j].d[1] < 1) {
							matrix[i][j].d[0] *= -1;
							matrix[i][j].d[1] *= -1;
						}
						x += matrix[i][j].d[0];
						y += matrix[i][j].d[1];
					}
					if (tmp[x][y] == null) {
						tmp[x][y] = matrix[i][j];
					} else if (tmp[x][y].z < matrix[i][j].z) {
						tmp[x][y] = matrix[i][j];
					}

				}
			}
			matrix = tmp.clone();
		}
		bw.write(weight + "");
		bw.flush();
		bw.close();
	}
}
