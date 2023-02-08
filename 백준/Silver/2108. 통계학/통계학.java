import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		double sum = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
		}

		Arrays.sort(nums);

		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
				continue;
			}
			map.put(nums[i], map.get(nums[i]) + 1);
		}

		List<Integer> values = new ArrayList<>(map.keySet());
		values.sort((v1, v2) -> {
			if (map.get(v2) == map.get(v1)) {
				return v1 - v2;
			} else
				return map.get(v2) - map.get(v1);
		});

		bw.write((int) Math.round(sum / N) + "\n");
		bw.write(nums[N / 2] + "\n");
		if (N > 1) {
			if (map.get(values.get(0)) == map.get(values.get(1))) {
				bw.write(values.get(1) + "\n");
			} else {
				bw.write(values.get(0) + "\n");
			}
		} else {
			bw.write(nums[0] + "\n");
		}
		bw.write(nums[N - 1] - nums[0] + "\n");

		bw.flush();
		bw.close();

	}
}