
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Vertex {
	int v;
	int w;

	public Vertex(int v, int w) {
		super();
		this.v = v;
		this.w = w;
	}

}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		ArrayList[] adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Vertex(v, w));
		}
		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		for (int c = 0; c < V; c++) {
			int min = Integer.MAX_VALUE;
			int current = -1;
			for (int i = 1; i <= V; i++) {
				if (!visited[i] && min > distance[i]) {
					current = i;
					min = distance[i];
				}
			}
			if (current == -1)
				break;
			visited[current] = true;
			for (int i = 0; i < adjList[current].size(); i++) {
				Vertex v = (Vertex) adjList[current].get(i);
				if (!visited[v.v] && distance[v.v] > min + v.w) {
					distance[v.v] = min + v.w;
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (distance[i] != Integer.MAX_VALUE)
				bw.write(distance[i] + "\n");
			else
				bw.write("INF\n");
		}
		bw.flush();
		bw.close();
	}
}
