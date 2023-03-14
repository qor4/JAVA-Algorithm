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

		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		int[][] answer = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			q.offer(i);
			while (!q.isEmpty()) {
				int n = q.poll();
				for (int j = 0; j < N; j++) {
					if (graph[n][j] == 0 || answer[i][j] == 1)
						continue;
					q.offer(j);
					answer[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(answer[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
