import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int N, W, H, min;
	static int[] nums;
	static int[][] map, tmpMap;
	static int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			nums = new int[N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			perm(0);

			bw.write("#" + tc + " " + min + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void perm(int cnt) {
		if (cnt == N) {
			// nums 순서대로 벽돌깨기
			tmpMap = new int[H][W];
			for (int i = 0; i < H; i++) {
				tmpMap[i] = map[i].clone();
			}
			for (int n : nums) {
				for (int i = 0; i < H; i++) {
					if (tmpMap[i][n] != 0) {
						remove(i, n);
						break;
					}
				}
				// 내리기
				for (int j = 0; j < W; j++) {
					int idx = H - 1;
					for (int i = H - 1; i >= 0; i--) {
						if (tmpMap[i][j] != 0) {
							tmpMap[idx][j] = tmpMap[i][j];
							if (idx != i)
								tmpMap[i][j] = 0;
							idx--;
						}
					}
				}
			}
			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (tmpMap[i][j] != 0)
						count++;
				}
			}
			min = Math.min(count, min);
			return;
		}
		for (int i = 0; i < W; i++) {
			nums[cnt] = i;
			perm(cnt + 1);
		}
	}

	private static void remove(int x, int y) {
		int s = tmpMap[x][y];
		tmpMap[x][y] = 0;
		for (int i = 1; i < s; i++) {
			if (x + i < H)
				remove(x + i, y);
			if (x - i >= 0)
				remove(x - i, y);
			if (y + i < W)
				remove(x, y + i);
			if (y - i >= 0)
				remove(x, y - i);
		}
	}
}
