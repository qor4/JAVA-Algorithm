import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split("-");
		int ans = 0;
		String[] tmp = arr[0].split("\\+");
		for (String t : tmp) {
			ans += Integer.parseInt(t);
		}

		for (int i = 1; i < arr.length; i++) {
			tmp = arr[i].split("\\+");
			for (String t : tmp) {
				ans -= Integer.parseInt(t);
			}
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}
