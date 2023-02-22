
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if (num == 1)
					cnt++;
			}
		}
		int max = 0;
		for (int i = 0; i < M - 2; i++) {
			for (int j = i + 1; j < M - 1; j++) {
				for (int k = j + 1; k < M; k++) {
					// 궁수 위치 i, j, k
					int result = 0;
					int tmpCnt = cnt;
					int[][] tempMap = new int[N][M];
					for (int r = 0; r < N; r++) {
						for (int c = 0; c < M; c++) {
							tempMap[r][c] = map[r][c];
						}
					}

					while (tmpCnt != 0) {
						int[] minAttack = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
						int[][] minLoc = { { -1, -1 }, { -1, -1 }, { -1, -1 } };
						for (int r = N - 1; r >= 0; r--) {
							for (int c = M - 1; c >= 0; c--) {
								if (tempMap[r][c] == 1) {
									if (minAttack[0] > Math.abs(N - r) + Math.abs(i - c)
											&& Math.abs(N - r) + Math.abs(i - c) <= D) {
										minAttack[0] = Math.abs(N - r) + Math.abs(i - c);
										minLoc[0][0] = r;
										minLoc[0][1] = c;

									} else if (minAttack[0] == Math.abs(N - r) + Math.abs(i - c)
									&& Math.abs(N - r) + Math.abs(i - c) <= D) {
				
										minLoc[0] = minLoc[0][1] < c ? minLoc[0] : new int[] { r, c };
									}

									if (minAttack[1] > Math.abs(N - r) + Math.abs(j - c)
											&& Math.abs(N - r) + Math.abs(j - c) <= D) {
										minAttack[1] = Math.abs(N - r) + Math.abs(j - c);
										minLoc[1][0] = r;
										minLoc[1][1] = c;
									} else if (minAttack[1] == Math.abs(N - r) + Math.abs(j - c)
									&& Math.abs(N - r) + Math.abs(j - c) <= D) {
										minLoc[1] = minLoc[1][1] < c ? minLoc[1] : new int[] { r, c };
									}

									if (minAttack[2] > Math.abs(N - r) + Math.abs(k - c)
											&& Math.abs(N - r) + Math.abs(k - c) <= D) {
										minAttack[2] = Math.abs(N - r) + Math.abs(k - c);
										minLoc[2][0] = r;
										minLoc[2][1] = c;
									} else if (minAttack[2] == Math.abs(N - r) + Math.abs(k - c)
									&& Math.abs(N - r) + Math.abs(k - c) <= D) {
										minLoc[2] = minLoc[2][1] < c ? minLoc[2] : new int[] { r, c };
									}
								}
							}
						}
						// 지워줌
						for (int[] l : minLoc) {
							if (l[0] != -1 && l[1] != -1 && tempMap[l[0]][l[1]] == 1) {
								tempMap[l[0]][l[1]] = 0;
								result++;
							}
						}

						
						// 내려줌
						for (int r = N - 1; r > 0; r--) {
							for (int c = 0; c < M; c++) {
								tempMap[r][c] = tempMap[r - 1][c];
							}
						}
						for (int c = 0; c < M; c++) {
							tempMap[0][c] = 0;
						}
						// cnt 개수 세기
						tmpCnt = 0;
						for (int r = 0; r < N; r++) {
							for (int c = 0; c < M; c++) {
								if (tempMap[r][c] == 1)
									tmpCnt++;
							}
						}

					}

					max = Math.max(max, result);

				}
			}
		}
		bw.write(max + "");
		bw.flush();
		bw.close();

	}
}
