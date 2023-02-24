import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int R, C, max;
	static char[][] map;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		max = -1;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, 1, new HashSet<>());

		bw.write(max + " ");
		bw.flush();
		bw.close();
	}

	private static void dfs(int x, int y, int cnt, HashSet<Character> visited) {
		visited.add(map[x][y]);
		int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
		for (int[] d : dir) {
			if (x + d[0] < 0 || x + d[0] >= R || y + d[1] < 0 || y + d[1] >= C)
				continue;
			if (!visited.contains(map[x + d[0]][y + d[1]])) {
				dfs(x + d[0], y + d[1], cnt + 1, visited);
			}
		}
		visited.remove(map[x][y]);
		max = Math.max(max, cnt);
	}

}