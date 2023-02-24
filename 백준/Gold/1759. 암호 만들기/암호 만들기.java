import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static String[] alphabet, pw;
	static boolean[] visited;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabet = br.readLine().split(" ");
		pw = new String[L];
		visited = new boolean[C];
		Arrays.sort(alphabet);
		comb(0, 0, 0, 0);
		bw.flush();
		bw.close();
	}

	private static void comb(int cnt, int start, int v, int c) throws IOException {
		if (cnt == L) {
			if (v >= 1 && c >= 2) {
				for (String s : pw) {
					bw.write(s);
				}
				bw.write("\n");
			}
			return;
		}
		for (int i = start; i < C; i++) {
			pw[cnt] = alphabet[i];
			if (pw[cnt].equals("a") || pw[cnt].equals("e") || pw[cnt].equals("i") || pw[cnt].equals("o")
					|| pw[cnt].equals("u"))
				comb(cnt + 1, i + 1, v + 1, c);
			else
				comb(cnt + 1, i + 1, v, c + 1);

		}

	}

}
