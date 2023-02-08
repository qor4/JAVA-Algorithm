import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] numbers, inputs;

	public static void main(String[] args) throws NumberFormatException, IOException {

		inputs = new int[9];
		numbers = new int[7];
		for (int i = 0; i < 9; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
		}
		search(0, 0);
		bw.flush();
		bw.close();
	}

	private static void search(int cnt, int start) throws IOException {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += numbers[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					bw.write(numbers[i] + "\n");
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			numbers[cnt] = inputs[i];
			search(cnt + 1, i + 1);
		}
	}
}
