import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);

		List<String> nums = Arrays.asList(br.readLine().split(" "));
		List<Integer> newNums = new ArrayList<>();
		List<Integer> sumNums = new ArrayList<>();

		for (String num : nums) {
			newNums.add(Integer.parseInt(num));
		}

		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = newNums.get(i) + newNums.get(j) + newNums.get(k);
					sumNums.add(sum);
				}
			}
		}

		Collections.sort(sumNums, Collections.reverseOrder());
		for (Integer num : sumNums) {
			if (num <= M) {
				System.out.println(num);
				break;
			}
		}
	}
}