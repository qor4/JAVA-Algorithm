
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static Integer[] set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			set = new Integer[n + 1];
			for (int i = 1; i <= n; i++) {
				set[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			Set<Integer> p = new HashSet<Integer>(Arrays.asList(set));
			bw.write("#" + tc + " " + (p.size() - 1));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static void union(int a, int b) {
		int temp = set[b];
		set[b] = set[a];
		for (int i = 1; i <= n; i++) {
			if (set[i] == temp) {
				set[i] = set[a];
			}
		}
		set[b] = set[a];
	}

}
