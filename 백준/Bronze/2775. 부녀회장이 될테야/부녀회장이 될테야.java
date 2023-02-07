import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apart = new int[k + 1][n + 1];

			for (int i = 0; i < k + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (i == 0)
						apart[0][j] = j;
					else {
						apart[i][j] = apart[i - 1][j] + apart[i][j - 1];
					}
				}
			}
			bw.write(apart[k][n] + "\n");
		}
		bw.flush();
		bw.close();

	}

}
