import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Deque<String> nums = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String ins = st.nextToken();
			if (ins.equals("push")) {
				nums.add(st.nextToken());
			}
			if (ins.equals("pop")) {
				if (nums.size() == 0) {
					bw.write(-1 + "\n");
				} else {
					bw.write(nums.poll() + "\n");
				}
			}
			if (ins.equals("size")) {
				bw.write(nums.size() + "\n");
			}
			if (ins.equals("empty")) {
				if (nums.size() == 0) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
			}
			if (ins.equals("front")) {
				if (nums.size() == 0) {
					bw.write(-1 + "\n");
				} else {
					bw.write(nums.peek() + "\n");
				}
			}
			if (ins.equals("back")) {
				if (nums.size() == 0) {
					bw.write(-1 + "\n");
				} else {
					bw.write(nums.peekLast() + "\n");
				}
			}
		}

		bw.flush();
		bw.close();

	}
}