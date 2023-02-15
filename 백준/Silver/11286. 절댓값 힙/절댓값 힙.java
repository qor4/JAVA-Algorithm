import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o2[0] == o1[0]) {
					return o1[1] - o2[1];
				} else
					return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0 && pq.isEmpty()) {
				bw.write(0 + "\n");
			} else if (num == 0) {
				int[] ans = pq.poll();
				bw.write(ans[1] + "\n");
			} else {
				pq.add(new int[] { Math.abs(num), num });
			}
		}

		bw.flush();
		bw.close();
	}
}
