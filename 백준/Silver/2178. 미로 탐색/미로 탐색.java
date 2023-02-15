import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] arr = new String[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split("");
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 1 });
		while (queue.size() != 0) {
			int[] dir = queue.poll();
			if (!arr[dir[0]][dir[1]].equals("1"))
				continue;
			arr[dir[0]][dir[1]] = String.valueOf(dir[2]);
			if (dir[0] + 1 < N)
				queue.add(new int[] { dir[0] + 1, dir[1], dir[2] + 1 });
			if (dir[1] + 1 < M)
				queue.add(new int[] { dir[0], dir[1] + 1, dir[2] + 1 });
			if (dir[0] - 1 >=0)
				queue.add(new int[] { dir[0] - 1, dir[1], dir[2] + 1 });
			if (dir[1] - 1 >=0)
				queue.add(new int[] { dir[0], dir[1] - 1, dir[2] + 1 });
		}
		bw.write(arr[N - 1][M - 1] + "");
		bw.flush();
		bw.close();
	}
}