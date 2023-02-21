
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[][] map;
	static int R, C, ans;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().split("");
		}
		
		for (int i = 0; i < R; i++) {
			flag = false;
			solve(i, 0);
			
			
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}

	private static void solve(int r, int c) {
		if(flag) return;
		map[r][c] = "0";
		if (c == C - 1) {
			ans++;
			flag = true;
			return;
		}
		if (r - 1 >= 0 && map[r - 1][c + 1].equals(".")) {
			solve(r - 1, c + 1);
		}
		if(flag) return;
		if (map[r][c + 1].equals(".")) {
			solve(r, c + 1);
		}
		if(flag) return;
		if (r + 1 < R && map[r + 1][c + 1].equals(".")) {
			solve(r + 1, c + 1);
		}
		if(flag) return;
	}

}
