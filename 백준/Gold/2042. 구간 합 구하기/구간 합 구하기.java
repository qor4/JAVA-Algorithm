import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] nums, tree;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		nums = new long[N + 1];
		tree = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		for (int i = 1; i <= N; i++) {
			update(i, nums[i]);
		}
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				update(b, (c - nums[b]));
				nums[b] = c;
			} else if (a == 2) {
				bw.write(getRange(b, c) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

	static void update(int index, long value) {
		while (index <= N) {
			tree[index] += value;
			index += (index & -index);
		}
	}

	static long sum(int index) {
		long result = 0;
		while (index > 0) {
			result += tree[index];
			index -= (index & -index);
		}
		return result;
	}

	static long getRange(int start, long end) {
		return sum((int) end) - sum(start - 1);
	}
}
