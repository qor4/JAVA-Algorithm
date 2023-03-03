import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Integer[]> q = new LinkedList<>();
		int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					q.offer(new Integer[] { i, j, 0 });
			}
		}

		while (!q.isEmpty()) {
			Integer[] t = q.poll();
			for (int[] d : dir) {
				if (t[0] + d[0] >= N || t[0] + d[0] < 0 || t[1] + d[1] >= M || t[1] + d[1] < 0)
					continue;
				if (map[t[0] + d[0]][t[1] + d[1]] == 0) {
					q.add(new Integer[] { t[0] + d[0], t[1] + d[1], t[2] + 1 });
					map[t[0] + d[0]][t[1] + d[1]] = 1;
				}
			}
			ans = t[2];
		}
		
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					flag = false;
			}
		}
		
		if (flag)
			bw.write(ans + "");
		else
			bw.write("-1");
		bw.flush();
		bw.close();
	}
}
