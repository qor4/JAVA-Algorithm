import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int idx = 0;
		int num = 1;
		while (idx < N && num <= N + 1) {
			if (stack.isEmpty()) {
				stack.add(num);
				sb.append("+\n");
				num++;
			}
			if (stack.peek() == numbers[idx]) {
				sb.append("-\n");
				stack.pop();
				idx++;
			} else {
				stack.add(num);
				sb.append("+\n");
				num++;
			}

		}
		if (num <= N + 1) {
			bw.write(sb.toString());
		} else {
			bw.write("NO");
		}
		bw.flush();
		bw.close();

	}
}