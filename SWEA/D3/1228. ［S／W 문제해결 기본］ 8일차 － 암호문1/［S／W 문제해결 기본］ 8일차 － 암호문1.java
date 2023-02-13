import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<String> c = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				c.add(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			String[][] ins = new String[M][];
			st = new StringTokenizer(br.readLine(), "I");
			for (int i = 0; i < M; i++) {
				ins[i] = st.nextToken().trim().split(" ");
			}
			for (int i = 0; i < ins.length; i++) {
				for (int j = 0; j < Integer.parseInt(ins[i][1]); j++) {
					c.add(Integer.parseInt(ins[i][0]) + j, ins[i][j+2]);
				}
			}

			bw.write("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				bw.write(c.get(i) + " ");
			}
			bw.write("\n");

		}
		bw.flush();
		bw.close();
	}
}
