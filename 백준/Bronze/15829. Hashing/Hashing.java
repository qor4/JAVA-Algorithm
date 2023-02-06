import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String alpha = br.readLine();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (alpha.charAt(i) - 'a' + 1) * Math.pow(31, i);

		}
		bw.write(sum % 1234567891 + "");
		bw.flush();
		bw.close();

	}
}
