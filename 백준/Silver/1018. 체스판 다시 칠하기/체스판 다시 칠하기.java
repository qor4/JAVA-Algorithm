import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] arr = new String[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split("");
		}
		String[][] a = new String[][] { { "B", "W" }, { "W", "B" } };
		String[][] b = new String[][] { { "W", "B" }, { "B", "W" } };

		int min = M * N;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int countA = 0;
				int countB = 0;
				for (int k = i; k < i + 8; k++) {
					for (int l = j; l < j + 8; l++) {
						if (!arr[k][l].equals(a[(k - i) % 2][(l - j) % 2])) {
							countA++;
						}
						if (!arr[k][l].equals(b[(k - i) % 2][(l - j) % 2])) {
							countB++;
						}
					}
				}
				min = Math.min(min, Math.min(countA, countB));
			}
		}

		bw.write(min + "");
		bw.flush();
		bw.close();

	}
}