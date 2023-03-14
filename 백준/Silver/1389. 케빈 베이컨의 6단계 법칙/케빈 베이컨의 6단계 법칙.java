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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}

		int[] level = new int[N + 1];
		Queue<Integer[]> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N + 1];
			q.add(new Integer[] { i, 1 });
			visited[i] = true;
			while (!q.isEmpty()) {
				Integer[] n = q.poll();
				for (int f : graph[n[0]]) {
					if (visited[f])
						continue;
					q.add(new Integer[] { f, n[1] + 1 });
					visited[f] = true;
					level[i] += n[1];
				}
			}

		}
		int ans = 1;
		for (int i = 2; i <= N; i++) {
			if (level[ans] > level[i])
				ans = i;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}

}
