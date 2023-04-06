import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] info = new int[101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[101];
		boolean[] visited = new boolean[101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 1; i <= 6; i++) {
				if (cur + i > 100 || visited[cur + i])
					continue;
				dp[cur + i] = Math.min(dp[cur + i], dp[cur] + 1);
				if (info[cur + i] != 0) {
					dp[info[cur + i]] = Math.min(dp[cur] + 1, dp[info[cur + i]]);
					queue.add(info[cur + i]);
				} else {
					queue.add(cur + i);
				}
				visited[cur + i] = true;
			}
		}
		bw.write(dp[100] + "");
		bw.flush();
		bw.close();
	}
}
