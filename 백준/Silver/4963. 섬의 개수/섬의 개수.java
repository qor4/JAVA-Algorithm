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
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w + h == 0)
				break;
			int[][] map = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;
			int[][] dir = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
					{ 1, 1 } };
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					Queue<Integer[]> queue = new LinkedList<>();
					if (map[i][j] == 1 && !visited[i][j]) {
						queue.add(new Integer[] { i, j });
						visited[i][j] = true;
						answer++;
					} else
						continue;
					while (!queue.isEmpty()) {
						Integer[] pos = queue.poll();
						int x = pos[0];
						int y = pos[1];
						for (int[] d : dir) {
							int newX = x + d[0];
							int newY = y + d[1];
							if (newX >= 0 && newY >= 0 && newX < h && newY < w && map[newX][newY] == 1
									&& !visited[newX][newY]) {
								queue.add(new Integer[] { newX, newY });
								visited[newX][newY] = true;
							}
						}
					}
				}
			}
			bw.write(answer + "\n");
		}
		bw.flush();
		bw.close();
	}
}
