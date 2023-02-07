import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	static int N, M;
	static int[] inputs, numbers;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		inputs = new int[N];
		numbers = new int[M];
		for (int i = 1; i < N + 1; i++) {
			inputs[i - 1] = i;
		}
		perm(0);
		
		bw.flush();
		bw.close();
	}

	private static void perm(int cnt) throws IOException {
		if (cnt == M) {
			for (int i = 0; i < numbers.length; i++) {
				bw.write(numbers[i] + " ");
			}
			bw.write("\n");
			
			return;
		}
		for (int i = 0; i < N; i++) {
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
		}
	}
}
