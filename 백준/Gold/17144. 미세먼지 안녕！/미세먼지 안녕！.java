import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int[][] newMap = new int[R][C];
		int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		List<Integer[]> pos = new ArrayList<>();
		int s = 1;
		int answer = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					pos.add(new Integer[] { i, s });
					s *= -1;
				}

			}
		}

		// t초 동안
		for (int t = 0; t < T; t++) {
			// 미세먼지 확산
			// newMap 초기화
			for (int i = 0; i < R; i++) {
				Arrays.fill(newMap[i], 0);
			}
			for (Integer[] p : pos) {
				newMap[p[0]][0] = -1;
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 0 || map[i][j] == -1)
						continue;
					int cnt = 4;
					for (int[] d : dir) {
						if (i + d[0] >= R || i + d[0] < 0 || j + d[1] >= C || j + d[1] < 0
								|| newMap[i + d[0]][j + d[1]] == -1) {
							cnt--;
							continue;
						}
						newMap[i + d[0]][j + d[1]] += (int) map[i][j] / 5;
					}
					newMap[i][j] += map[i][j] - (((int) map[i][j] / 5) * cnt);

				}
			}
			// newMap을 map에 복제
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = newMap[i][j];
				}
			}
			
			// 공기청정기 작동
			for (Integer[] p : pos) {
				if (p[1] == 1) {
					// 아래로
					for (int i = p[0]-1; i >0; i--) {
						map[i][0] = map[i - 1][0];
					}
					// 왼쪽으로
					for (int i = 0; i < C - 1; i++) {
						map[0][i] = map[0][i + 1];
					}
					// 위로
					for (int i = 0; i < p[0]; i++) {
						map[i][C - 1] = map[i + 1][C - 1];
					}
					// 오른쪽으로
					for (int i = C - 1; i > 1; i--) {
						map[p[0]][i] = map[p[0]][i - 1];
					}
					map[p[0]][1] = 0;
				} else if (p[1] == -1) {
					// 위로
					for (int i = p[0] + 1; i < R - 1; i++) {
						map[i][0] = map[i + 1][0];
					}
					// 왼쪽으로
					for (int i = 0; i < C - 1; i++) {
						map[R - 1][i] = map[R - 1][i + 1];
					}
					// 아래로
					for (int i = R - 1; i > p[0]; i--) {
						map[i][C - 1] = map[i - 1][C - 1];
					}
					// 오른쪽으로
					for (int i = C - 1; i > 1; i--) {
						map[p[0]][i] = map[p[0]][i - 1];
					}
					map[p[0]][1] = 0;
				}

			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					answer += map[i][j];
			}
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();

	}
}
