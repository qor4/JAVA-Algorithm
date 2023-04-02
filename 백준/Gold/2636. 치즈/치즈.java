import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] ans = new int[2];
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int[][] copyMap = new int[N][M];
		Queue<Integer[]> queue = new LinkedList<>();
		while (true) {
			// 치즈 수 세기
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						cnt += 1;
					}
				}
			}
			if (cnt == 0)
				break;
			else {
				ans[0]++;
				ans[1] = cnt;
			}
			// 빈 공간 구하기
			for (int i = 0; i < N; i++) {
				Arrays.fill(copyMap[i], 0);
			}
			queue.add(new Integer[] { 0, 0 });
			while (!queue.isEmpty()) {
				Integer[] coor = queue.poll();
				for (int[] d : dir) {
					if (coor[0] + d[0] < 0 || coor[0] + d[0] >= N || coor[1] + d[1] < 0 || coor[1] + d[1] >= M
							|| map[coor[0] + d[0]][coor[1] + d[1]] == 1 || copyMap[coor[0] + d[0]][coor[1] + d[1]] == 1)
						continue;
					queue.add(new Integer[] { coor[0] + d[0], coor[1] + d[1] });
					copyMap[coor[0] + d[0]][coor[1] + d[1]] = 1;
				}
			}
			// 치즈 녹이기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int[] d : dir) {
						if (i + d[0] < 0 || i + d[0] >= N || j + d[1] < 0 || j + d[1] >= M)
							continue;
						if (copyMap[i + d[0]][j + d[1]] == 1 && map[i][j] == 1) {
							map[i][j] = 0;
						}
					}
				}
			}

		}
		bw.write(ans[0] + "\n" + ans[1]);
		bw.flush();
		bw.close();
	}
}