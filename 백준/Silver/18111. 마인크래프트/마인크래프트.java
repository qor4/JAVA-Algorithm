import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int min = 257;
		int max = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = map[i][j] < min ? map[i][j] : min;
				max = map[i][j] > max ? map[i][j] : max;
			}
		}
		int minTime = Integer.MAX_VALUE;
		int hight = 0;
		for (int i = min; i <= max; i++) {
			int inventory = 0;
			int time = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[j][k] > i) {
						int cnt = map[j][k] - i;
						inventory += cnt;
						time += 2 * cnt;
					} else if (map[j][k] < i) {
						int cnt = i - map[j][k];
						inventory -= cnt;
						time += cnt;
					}
				}
			}
			if (B + inventory >= 0 && time <= minTime) {
				minTime = time;
				hight = i;
			}
		}
		bw.write(minTime + " " + hight);
		bw.flush();
		bw.close();

	}
}