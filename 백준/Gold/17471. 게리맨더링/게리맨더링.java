
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, min;
	static boolean[] visited;
	static int[][] graph;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		p = new int[N + 1];
		graph = new int[N + 1][];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			graph[i] = new int[n];
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		visited = new boolean[N + 1];
		subset(1);
		if (min == Integer.MAX_VALUE) {
			bw.write("-1");
		} else {
			bw.write(min + "");
		}
		bw.flush();
		bw.close();
	}

	private static void subset(int cnt) {
		if (cnt == N + 1) {
			for (int i = 1; i <= N; i++) {
				int c = 0;
				for (int j = 1; j <= N; j++) {
					if (visited[j])
						c++;
				}
				if (c == N)
					continue;
				if (search(true) && search(false)) {
					int sum1 = 0;
					int sum2 = 0;
					for (int j = 1; j <= N; j++) {
						if (visited[j])
							sum1 += p[j];
						else
							sum2 += p[j];
					}
					min = Math.min(min, Math.abs(sum1 - sum2));
				}
			}
			return;
		}
		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);

	}

	private static boolean search(boolean b) {
		boolean[] v = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (visited[i] != b)
				v[i] = true;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (!v[i]) {
				q.offer(i);
				break;
			}
		}
		while (!q.isEmpty()) {
			int n = q.poll();
			v[n] = true;
			for (int i = 0; i < graph[n].length; i++) {
				if (!v[graph[n][i]]) {
					q.add(graph[n][i]);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (!v[i])
				return false;
		}
		return true;
	}
}
