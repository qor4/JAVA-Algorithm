import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList[] person;
	static int[] levels;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			person = new ArrayList[101];
			levels = new int[101];
			for (int i = 1; i < 101; i++) {
				person[i] = new ArrayList<Integer>();
			}
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				person[from].add(to);
			}
			max = 0;
			bfs(start);

			for (int i = 100; i > 0; i--) {
				if (levels[i] == max) {
					bw.write("#" + tc + " " + i + "\n");
					break;
				}
			}
		}
		bw.flush();
		bw.close();
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[101];
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int vertex = q.poll();
			for (int i = 0; i < person[vertex].size(); i++) {
				if (!visited[(int) person[vertex].get(i)]) {
					q.offer((int) person[vertex].get(i));
					levels[(int) person[vertex].get(i)] = levels[vertex] + 1;
					max = Math.max(max, levels[(int) person[vertex].get(i)]);
					visited[(int) person[vertex].get(i)] = true;
				}
			}
		}
	}
}
