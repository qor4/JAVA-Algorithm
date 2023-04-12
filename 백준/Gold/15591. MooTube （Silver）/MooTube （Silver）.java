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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		List<int[]>[] USADO = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			USADO[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			USADO[p].add(new int[] { q, r });
			USADO[q].add(new int[] { p, r });
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[N + 1];
			Queue<Integer> queue = new LinkedList<>();
			queue.add(v);
			visited[v] = true;
			int ans = 0;
			while (!queue.isEmpty()) {
				Integer node = queue.poll();
				for (int[] video : USADO[node]) {
					if (visited[video[0]] || video[1] < k)
						continue;
					queue.add(video[0]);
					visited[video[0]] = true;
					ans++;
				}
			}
			bw.write(ans + "\n");
		}
		bw.flush();
		bw.close();
	}
}
