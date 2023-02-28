import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String s = "I";
		for (int i = 0; i < N; i++) {
			s += "OI";
		}
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(S);
		int ans = 0;
		int idx = 0;
		while (m.find(idx)) {
			idx = m.start() + 1;
			ans++;
		}

		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}