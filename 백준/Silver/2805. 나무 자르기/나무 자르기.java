import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(trees);

		int e = trees[trees.length - 1];
		int s = 0;
		int max = 0;
		while (s <= e) {
			long ans = 0;
			int mid = (e + s) / 2;
			for (int tree : trees) {
				ans += Math.max(0, tree - mid);
			}
			if (ans < M)
				e = mid - 1;
			else {
				s = mid + 1;
				max = Math.max(max, mid);
			}
		}
		bw.write(max + "");
		bw.flush();
		bw.close();

	}
}