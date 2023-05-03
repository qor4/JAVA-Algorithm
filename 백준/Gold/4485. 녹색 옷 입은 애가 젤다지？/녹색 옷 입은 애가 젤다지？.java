import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int tc = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			int[][] visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}
			queue.add(new int[] { 0, 0, map[0][0] });
			visited[0][0] = map[0][0];

			while (!queue.isEmpty()) {
				int[] coor = queue.poll();
				for (int[] d : dir) {
					if (coor[0] + d[0] < 0 || coor[0] + d[0] >= N || coor[1] + d[1] < 0 || coor[1] + d[1] >= N
							|| visited[coor[0] + d[0]][coor[1] + d[1]] <= visited[coor[0]][coor[1]]
									+ map[coor[0] + d[0]][coor[1] + d[1]])
						continue;
					queue.add(new int[] { coor[0] + d[0], coor[1] + d[1],
							visited[coor[0]][coor[1]] + map[coor[0] + d[0]][coor[1] + d[1]] });
					visited[coor[0] + d[0]][coor[1] + d[1]] = visited[coor[0]][coor[1]]
							+ map[coor[0] + d[0]][coor[1] + d[1]];
				}
			}

			bw.write("Problem " + tc + ": " + visited[N - 1][N - 1] + "\n");
			tc++;
		}
		bw.flush();
		bw.close();
	}
}
