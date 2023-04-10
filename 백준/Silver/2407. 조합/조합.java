import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		BigInteger result = new BigInteger("1");
		for (int i = 1; i <= m; i++) {
			result = result.multiply(new BigInteger(String.valueOf(n - i + 1))) ;
			result = result.divide(new BigInteger(String.valueOf(i)));
		}
		bw.write(result.toString() + "");
		bw.flush();
		bw.close();
	}
}
