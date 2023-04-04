import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			Set<Integer>[] graph = new Set[N + 1];
			Set<Integer>[] graph2 = new Set[N + 1];
			for (int i = 0; i <= N; i++) {
				graph[i] = new HashSet<>();
				graph2[i] = new HashSet<>();
			}
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[b].add(a);
				graph2[a].add(b);
			}
			for (int i = 1; i <= N; i++) {
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				boolean[] visited = new boolean[N + 1];
				visited[i] = true;
				while (!queue.isEmpty()) {
					int n = queue.poll();
					for (int g : graph[n]) {
						if (visited[g])
							continue;
						queue.add(g);
						visited[g] = true;
						graph[i].add(g);
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				boolean[] visited = new boolean[N + 1];
				visited[i] = true;
				while (!queue.isEmpty()) {
					int n = queue.poll();
					for (int g : graph2[n]) {
						if (visited[g])
							continue;
						queue.add(g);
						visited[g] = true;
						graph2[i].add(g);
					}
				}
			}

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				int cnt = graph[i].size() + graph2[i].size();
				if (cnt == N - 1)
					ans++;
			}
			bw.write("#" + tc + " " + ans + "\n");
		}
		bw.flush();
		bw.close();
	}
}
