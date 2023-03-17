import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = Integer.MAX_VALUE;
		Queue<Integer[]> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		q.add(new Integer[] { N, 0 });
		visited[N] = true;
		while (!q.isEmpty()) {
			Integer[] cur = q.poll();
			if (cur[0] == K) {
				ans = Math.min(ans, cur[1]);
				continue;
			}
			if (cur[0] - 1 >= 0 && !visited[cur[0] - 1]) {
				q.add(new Integer[] { cur[0] - 1, cur[1] + 1 });
				visited[cur[0] - 1] = true;
			}
			if (cur[0] + 1 <= 100000 && !visited[cur[0] + 1]) {
				q.add(new Integer[] { cur[0] + 1, cur[1] + 1 });
				visited[cur[0] + 1] = true;
			}
			if (cur[0] * 2 <= 100000 && !visited[cur[0] * 2]) {
				q.add(new Integer[] { cur[0] * 2, cur[1] + 1 });
				visited[cur[0] * 2] = true;
			}

		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}

}