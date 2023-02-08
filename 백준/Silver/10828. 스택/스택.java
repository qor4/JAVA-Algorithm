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
		Stack<String> nums = new Stack<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String ins = st.nextToken();
			if (ins.equals("push")) {
				nums.push(st.nextToken());
			}
			if (ins.equals("pop")) {
				if (nums.empty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(nums.peek() + "\n");
					nums.pop();
				}
			}
			if (ins.equals("size")) {
				bw.write(nums.size() + "\n");
			}
			if (ins.equals("empty")) {
				if (nums.empty()) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
			}
			if (ins.equals("top")) {
				if (nums.empty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(nums.peek() + "\n");
				}
			}
		}

		bw.flush();
		bw.close();

	}
}