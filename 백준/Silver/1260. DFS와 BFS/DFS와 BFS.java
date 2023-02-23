import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[];
	static ArrayList<Integer>[] graph;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}
		for (int i = 0; i < N + 1; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}
		visited = new boolean[N + 1];
		dfs(V);
		bw.write("\n");
		for (int i = 0; i < N + 1; i++) {
			Collections.sort(graph[i]);
		}
		visited = new boolean[N + 1];
		bfs(V);
		bw.flush();
		bw.close();
	}

	private static void dfs(int v) throws IOException {
		Stack<Integer> s = new Stack<>();
		s.add(v);
		while (!s.isEmpty()) {
			int n = s.pop();
			if (visited[n])
				continue;
			visited[n] = true;
			bw.write(n + " ");
			for (int i = 0; i < graph[n].size(); i++) {
				s.add(graph[n].get(i));
			}
		}
	}

	private static void bfs(int v) throws IOException {
		Queue<Integer> q = new LinkedList<>();

		q.add(v);
		visited[v] = true;
		while (!q.isEmpty()) {
			int n = q.poll();
			bw.write(n + " ");
			for (int i = 0; i < graph[n].size(); i++) {
				if (visited[graph[n].get(i)])
					continue;
				q.add(graph[n].get(i));
				visited[graph[n].get(i)] = true;
			}

		}

	}
}
