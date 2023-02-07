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

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] str = br.readLine().split("");
			if (str.length % 2 != 0) {
				bw.write("NO\n");
				continue;
			}
			List<String> stack = new ArrayList<>();
			for (String s : str) {
				stack.add(s);
				if (stack.size() >= 2 && stack.get(stack.size() - 1).equals(")")
						&& stack.get(stack.size() - 2).equals("(")) {
					stack.remove(stack.size() - 1);
					stack.remove(stack.size() - 1);
				}
			}
			if (stack.size() > 0)
				bw.write("NO\n");
			else
				bw.write("YES\n");
		}
		bw.flush();
		bw.close();

	}
}
