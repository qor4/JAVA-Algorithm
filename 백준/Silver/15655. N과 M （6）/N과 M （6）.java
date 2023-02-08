import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] numbers, inputs;
	static boolean[] visited;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		inputs = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputs);
		comb(0, 0);
		bw.flush();
		bw.close();
	}

	private static void comb(int cnt, int start) throws IOException {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				bw.write(numbers[i] + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			if (visited[i])
				continue;
			numbers[cnt] = inputs[i];
			visited[i] = true;
			comb(cnt + 1, i + 1);
			visited[i] = false;
		}

	}
}
