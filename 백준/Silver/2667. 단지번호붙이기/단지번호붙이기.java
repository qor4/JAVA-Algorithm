import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[][] dir = new int[][] { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
		List<Integer> cnts = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				Queue<Integer[]> queue = new LinkedList<>();
				if (map[i][j] == '1' && !visited[i][j]) {
					queue.add(new Integer[] { i, j });
					visited[i][j] = true;
				} else
					continue;
				while (!queue.isEmpty()) {
					cnt++;
					Integer[] pos = queue.poll();
					int x = pos[0];
					int y = pos[1];
					for (int[] d : dir) {
						int newX = x + d[0];
						int newY = y + d[1];
						if (newX >= 0 && newY >= 0 && newX < N && newY < N && map[newX][newY] == '1'
								&& !visited[newX][newY]) {
							queue.add(new Integer[] { newX, newY });
							visited[newX][newY] = true;
						}
					}
				}
				cnts.add(cnt);
			}
		}
		Collections.sort(cnts);
		bw.write(cnts.size() + "\n");
		for (int cnt : cnts) {
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();
	}
}
