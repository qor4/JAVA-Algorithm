import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Fish {
	int x;
	int y;
	int dis;

	public Fish(int x, int y, int dis) {
		super();
		this.x = x;
		this.y = y;
		this.dis = dis;
	}

	@Override
	public String toString() {
		return "Fish [x=" + x + ", y=" + y + ", dis=" + dis + "]";
	}

}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int x = 0;
		int y = 0;
		int size = 2;
		int eat = 0;
		List<Fish> fishList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					x = i;
					y = j;
					map[i][j] = 0;
				}
			}
		}
		int ans = 0;
		Queue<Integer[]> q = new LinkedList<>();
		while (true) {
			boolean[][] visited = new boolean[N][N];
			q.add(new Integer[] { x, y, 1 });
			while (!q.isEmpty()) {
				Integer[] f = q.poll();
				visited[f[0]][f[1]] = true;
				for (int[] d : dir) {
					if (f[0] + d[0] < 0 || f[0] + d[0] >= N || f[1] + d[1] < 0 || f[1] + d[1] >= N)
						continue;
					// 추가될 때 : size보다 작을 때, 0이 아닐때
					// 지나갈 수 있을 때:size보다 작거나 같을 때
					if (map[f[0] + d[0]][f[1] + d[1]] <= size && !visited[f[0] + d[0]][f[1] + d[1]]) {
						q.add(new Integer[] { f[0] + d[0], f[1] + d[1], f[2] + 1 });
						visited[f[0] + d[0]][f[1] + d[1]] = true;
						if (map[f[0] + d[0]][f[1] + d[1]] != size && map[f[0] + d[0]][f[1] + d[1]] != 0) {
							fishList.add(new Fish(f[0] + d[0], f[1] + d[1], f[2]));
						}
					}
				}
			}

			if (fishList.size() == 0) {
				break;
			} else {
				Collections.sort(fishList, new Comparator<Fish>() {
					@Override
					public int compare(Fish o1, Fish o2) {
						return o1.dis != o2.dis ? o1.dis - o2.dis : o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
					}
				});
			}
			map[fishList.get(0).x][fishList.get(0).y] = 0;
			eat++;
			if (eat == size) {
				eat = 0;
				size++;
			}
			x = fishList.get(0).x;
			y = fishList.get(0).y;
			ans += fishList.get(0).dis;
			fishList.clear();
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}

}
