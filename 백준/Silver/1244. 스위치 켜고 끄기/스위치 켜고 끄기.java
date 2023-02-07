import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] switchs = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < N + 1; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int K = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			if (K == 1) {
				for (int j = L; j <= N; j += L) {
					if (switchs[j] == 1)
						switchs[j] = 0;
					else
						switchs[j] = 1;
				}
			} else {
				int idx = 1;
				while (true) {
					if (L - idx > 0 && L + idx < N + 1 && switchs[L - idx] == switchs[L + idx])
						idx++;
					else
						break;
				}

				for (int j = (L - idx + 1); j < (L + idx); j++) {
					if (switchs[j] == 1)
						switchs[j] = 0;
					else
						switchs[j] = 1;
				}
			}
		}

		for (int i = 1; i < switchs.length; i++) {
			bw.write(switchs[i] + " ");
			if(i % 20 == 0) {
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
