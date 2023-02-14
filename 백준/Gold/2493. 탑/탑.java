import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int h = Integer.parseInt(st.nextToken());
			while (true) {
				if (stack.isEmpty()) {
					bw.write("0 ");
					break;
				} else if (stack.peek()[1] >= h) {
					bw.write(stack.peek()[0] + " ");
					break;
				} else {
					stack.pop();
				}
			}
			stack.push(new int[] { i, h });
		}

		bw.flush();
		bw.close();
	}
}
