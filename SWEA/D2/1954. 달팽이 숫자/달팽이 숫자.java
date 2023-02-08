import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int x = 0;
			int y = 0;
			int num = 1;
			int cnt = N - 1;

			while (true) {
				if (cnt < 0)
					break;
				for (int i = 0; i < cnt; i++) {
					arr[y][x] = num;
					num++;
					x++;
				}
				for (int i = 0; i < cnt; i++) {
					arr[y][x] = num;
					num++;
					y++;
				}
				for (int i = 0; i < cnt; i++) {
					arr[y][x] = num;
					num++;
					x--;
				}
				for (int i = 0; i < cnt; i++) {
					arr[y][x] = num;
					num++;
					y--;
				}
				x++;
				y++;
				cnt -= 2;
			}

			if (N % 2 != 0)
				arr[N / 2][N / 2] = num;
			bw.write("#" + tc + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bw.write(arr[i][j] + " ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
