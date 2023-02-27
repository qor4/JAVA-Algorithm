
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[] set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			bw.write("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			set = new int[n + 1];
			for (int i = 1; i < n; i++) {
				set[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int ins = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (ins == 0) {
					union(a, b);
				} else if (ins == 1) {
					if (find(a) == find(b)) {
						bw.write("1");
					} else {
						bw.write("0");
					}
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static void union(int a, int b) {
		// a 집합의 대표 찾기
		int aRoot = find(a);
		// b 집합의 대표 찾기
		int bRoot = find(b);
		set[bRoot] = aRoot;
	}

	private static int find(int a) {
		if (set[a] == a)
			return a;
		return set[a] = find(set[a]);

	}

}
