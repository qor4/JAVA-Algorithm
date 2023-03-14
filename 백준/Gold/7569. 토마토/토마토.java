import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;
	int z;
	int day;

	public Pos(int x, int y, int z, int day) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.day = day;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] dir = new int[][] { { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, -1 }, { 0, 0, 1 } };
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] map = new int[H][N][M];
		int ans = 0;
		Queue<Pos> q = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) {
						q.add(new Pos(j, k, i, 0));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int[] d : dir) {
				if (p.x + d[0] < 0 || p.x + d[0] >= N || p.y + d[1] < 0 || p.y + d[1] >= M || p.z + d[2] < 0
						|| p.z + d[2] >= H)
					continue;
				if (map[p.z + d[2]][p.x + d[0]][p.y + d[1]] == 0) {
					q.add(new Pos(p.x + d[0], p.y + d[1], p.z + d[2], p.day + 1));
					map[p.z + d[2]][p.x + d[0]][p.y + d[1]] = 1;
				}
			}
			ans = Math.max(p.day, ans);
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0) {
						ans = -1;
						break;
					}
				}
			}
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}

}
