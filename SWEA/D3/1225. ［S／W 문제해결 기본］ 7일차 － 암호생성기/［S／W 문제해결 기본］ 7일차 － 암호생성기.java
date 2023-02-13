
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			int cnt = 1;
			while (true) {
				if (q.peek() - cnt <= 0) {
					q.poll();
					q.offer(0);
					break;
				}
				q.offer(q.poll() - cnt);
				cnt++;
				if (cnt > 5)
					cnt = 1;
			}

			bw.write("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				bw.write(q.poll() + " ");
			}
			bw.write("\n");

		}
		bw.flush();
		bw.close();
	}
}
