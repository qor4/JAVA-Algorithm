import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[][] map, coors;
	static List<int[]> list;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		list = new ArrayList<>();
		coors = new int[M][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new int[] { i, j, 1 });
				}
			}
		}
		ans = Integer.MAX_VALUE;
		comb(0, 0);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			int[][] copyMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				copyMap[i] = map[i].clone();
			}
			Queue<int[]> queue = new LinkedList<>();
			for (int[] coor : coors) {
				queue.add(coor);
			}
			int sec = 0;
			int zeroCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copyMap[i][j] == 0) {
						zeroCnt++;
					}
				}
			}
			while (!(queue.isEmpty() || zeroCnt == 0)) {
				int[] c = queue.poll();
				sec = Math.max(sec, c[2]);
				for (int[] d : dir) {
					if (c[0] + d[0] < 0 || c[0] + d[0] >= N || c[1] + d[1] < 0 || c[1] + d[1] >= N
							|| copyMap[c[0] + d[0]][c[1] + d[1]] == 1)
						continue;
					queue.add(new int[] { c[0] + d[0], c[1] + d[1], c[2] + 1 });
					if (copyMap[c[0] + d[0]][c[1] + d[1]] == 0)
						zeroCnt--;
					copyMap[c[0] + d[0]][c[1] + d[1]] = 1;
				}
			}

			if (zeroCnt != 0)
				return;
			ans = Math.min(ans, sec);
			return;
		}
		for (int i = start; i < list.size(); i++) {
			coors[cnt] = list.get(i);
			comb(cnt + 1, i + 1);
		}

	}
}
