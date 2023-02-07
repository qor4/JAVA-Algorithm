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

		while (true) {
			String[] str = br.readLine().split("");
			if (str[0].equals("."))
				break;
			List<String> stack = new ArrayList<>();
			for (String s : str) {
				if (s.equals("[") || s.equals("]") || s.equals("(") || s.equals(")")) {
					stack.add(s);
					if (stack.size() >= 2 && stack.get(stack.size() - 1).equals(")")
							&& stack.get(stack.size() - 2).equals("(")) {
						stack.remove(stack.size() - 1);
						stack.remove(stack.size() - 1);
					}
					if (stack.size() >= 2 && stack.get(stack.size() - 1).equals("]")
							&& stack.get(stack.size() - 2).equals("[")) {
						stack.remove(stack.size() - 1);
						stack.remove(stack.size() - 1);
					}
				}

			}

			if (stack.size() > 0)
				bw.write("no\n");
			else
				bw.write("yes\n");
		}

		bw.flush();
		bw.close();

	}
}
