import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int value;
	String instruction;

	public Node(int value, String instruction) {
		super();
		this.value = value;
		this.instruction = instruction;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", instruction=" + instruction.toString() + "]";
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[10000];
			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(A, ""));
			visited[A] = true;
			while (!queue.isEmpty()) {
				Node n = queue.poll();
				if (n.value == B) {
					for (String i : n.instruction.split("")) {
						bw.write(i);
					}
					bw.write("\n");
					break;
				}

				// D
				if (!visited[(n.value * 2) % 10000]) {
					queue.add(new Node((n.value * 2) % 10000, n.instruction + "D"));
					visited[(n.value * 2) % 10000] = true;
				}
				// S
				if (!visited[n.value == 0 ? 9999 : n.value - 1]) {
					queue.add(new Node(n.value == 0 ? 9999 : n.value - 1, n.instruction + "S"));
					visited[n.value == 0 ? 9999 : n.value - 1] = true;
				}
				// L
				String val = Integer.toString(n.value);
				for (int i = 0; i < 4 - Integer.toString(n.value).length(); i++) {
					val = "0" + val;
				}
				int num = 0;
				for (int i = 1; i < 4; i++) {
					num = (num * 10) + (val.charAt(i) - '0');
				}
				num = (num * 10) + val.charAt(0) - '0';
				if (!visited[num]) {
					queue.add(new Node(num, n.instruction + "L"));
					visited[num] = true;
				}
				// R
				val = Integer.toString(n.value);
				for (int i = 0; i < 4 - Integer.toString(n.value).length(); i++) {
					val = "0" + val;
				}

				num = val.charAt(3) - '0';
				for (int i = 0; i < 3; i++) {
					num = (num * 10) + (val.charAt(i) - '0');
				}
				if (!visited[num]) {
					queue.add(new Node(num, n.instruction + "R"));
					visited[num] = true;
				}
			}
		}
		bw.flush();
		bw.close();
	}
}