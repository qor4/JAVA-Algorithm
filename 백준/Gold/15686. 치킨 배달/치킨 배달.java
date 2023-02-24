
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Coor {
	int x;
	int y;

	public Coor(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Coor [x=" + x + ", y=" + y + "]";
	}
}

public class Main {
	static int chickenCnt, homeCnt, N, M, min;
	static Coor[] chicken, home, index;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		chickenCnt = 0;
		homeCnt = 0;
		chicken = new Coor[13];
		home = new Coor[2 * N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					chicken[chickenCnt++] = new Coor(i, j);
				if (map[i][j] == 1)
					home[homeCnt++] = new Coor(i, j);
			}
		}

		index = new Coor[M];
		visited = new boolean[chickenCnt];
		min = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(min);
	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			int sum = 0;
//			for(Coor s:index) {
//				System.out.println(s.toString());
//			}
			for (int i = 0; i < homeCnt; i++) {
				int homeX = home[i].x;
				int homeY = home[i].y;
				int dis = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					int chickenX = index[j].x;
					int chickenY = index[j].y;
					dis = Math.min(Math.abs(homeX - chickenX) + Math.abs(homeY - chickenY), dis);
				}
				sum += dis;
			}
//			System.out.println(sum);
			min = Math.min(sum, min);
			return;
		}
		for (int i = start; i < chickenCnt; i++) {
//			if (visited[i])
//				continue;
			index[cnt] = chicken[i];
//			visited[i] = true;
			comb(cnt + 1, i + 1);

		}

	}

}
