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
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		boolean[] truth = new boolean[N + 1];
		int ans = 0;
		List[] party = new List[N + 1];
		List[] map = new List[M];
		for (int i = 0; i <= N; i++) {
			party[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			truth[Integer.parseInt(st.nextToken())] = true;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			map[i].add(s);
			for (int j = 0; j < m - 1; j++) {
				int e = Integer.parseInt(st.nextToken());
				map[i].add(e);
				party[s].add(e);
				party[e].add(s);
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (truth[i]) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int num = queue.poll();
			for (int i = 0; i < party[num].size(); i++) {
				if (truth[(int) party[num].get(i)])
					continue;
				queue.add((int) party[num].get(i));
				truth[(int) party[num].get(i)] = true;
			}
		}
		for (int i = 0; i < M; i++) {
			boolean flag = true;
			for (int j = 0; j < map[i].size(); j++) {
				if (truth[(int) map[i].get(j)]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				ans++;
			}
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
