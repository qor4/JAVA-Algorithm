
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] numbers;
	static boolean[] visited;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		visited = new boolean[N];
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
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = i + 1;
			comb(cnt + 1, i + 1);
		}

	}
}
