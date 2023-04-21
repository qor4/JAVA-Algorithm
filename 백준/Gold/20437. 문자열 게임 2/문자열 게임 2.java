import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());

			int[] check = new int[26];
			int min = Integer.MAX_VALUE;
			int max = -1;
			boolean flag = true;

			for (int i = 0; i < W.length(); i++) {
				check[W.charAt(i) - 'a']++;
			}

			for (int i = 0; i < W.length(); i++) {
				if (check[W.charAt(i) - 'a'] < K)
					continue;
				int cnt = 0;
				for (int j = i; j < W.length(); j++) {
					if (W.charAt(i) == W.charAt(j))
						cnt++;
					if (cnt == K) {
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1);
						flag = false;
						break;
					}
				}
			}

			if (flag)
				bw.write("-1\n");
			else
				bw.write(min + " " + max + "\n");
		}
		bw.flush();
		bw.close();
	}
}