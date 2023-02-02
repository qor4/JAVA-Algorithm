import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		int[] nums = new int[10000];
		for (int i = 0; i < N; i++) {
			nums[Integer.parseInt(bf.readLine()) - 1] += 1;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i]; j++) {
				bw.write((i + 1) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
