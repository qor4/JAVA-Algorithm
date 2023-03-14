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

		int N = Integer.parseInt(br.readLine());
		List<Integer>[] net = new ArrayList[N + 1];
		int M = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 0; i < N + 1; i++) {
			net[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			net[from].add(to);
			net[to].add(from);
		}

		boolean[] visited = new boolean[N + 1];

		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while (!q.isEmpty()) {
			int n = q.poll();
			visited[n] = true;
			for (Integer t : net[n]) {
				if (visited[t])
					continue;
				q.offer(t);
			}
		}

		for (boolean b : visited) {
			if (b)
				ans++;
		}

		bw.write(ans - 1 + "");
		bw.flush();
		bw.close();
	}
}