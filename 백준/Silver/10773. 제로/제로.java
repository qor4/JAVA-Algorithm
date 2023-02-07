import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(br.readLine());
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				nums.add(num);
			} else {
				nums.remove(nums.size() - 1);
			}
		}
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}
