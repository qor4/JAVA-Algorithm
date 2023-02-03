import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(bf.readLine()));
		}
		Collections.sort(nums);
		for (Integer num : nums) {
			bw.write(num + "\n");
		}
		bw.flush();
		bw.close();
	}
}