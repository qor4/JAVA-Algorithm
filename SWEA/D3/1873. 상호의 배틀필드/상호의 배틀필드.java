
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			String[][] map = new String[H][W];
			int[] position = new int[4];
			for (int i = 0; i < H; i++) {
				String[] arr = br.readLine().split("");
				for (int j = 0; j < W; j++) {
					map[i][j] = arr[j];
					if (map[i][j].equals("^")) {
						position[0] = i;
						position[1] = j;
						position[2] = -1;
						position[3] = 0;
					} else if (map[i][j].equals("v")) {
						position[0] = i;
						position[1] = j;
						position[2] = 1;
						position[3] = 0;
					} else if (map[i][j].equals("<")) {
						position[0] = i;
						position[1] = j;
						position[2] = 0;
						position[3] = -1;
					} else if (map[i][j].equals(">")) {
						position[0] = i;
						position[1] = j;
						position[2] = 0;
						position[3] = 1;
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split("");
			for (String s : str) {
				if (s.equals("U")) {
					if (position[0] - 1 >= 0 && map[position[0] - 1][position[1]].equals(".")) {
						map[position[0]][position[1]] = ".";
						position[0] = position[0] - 1;
					}
					position[2] = -1;
					position[3] = 0;
					map[position[0]][position[1]] = "^";
				} else if (s.equals("D")) {
					if (position[0] + 1 < H && map[position[0] + 1][position[1]].equals(".")) {
						map[position[0]][position[1]] = ".";
						position[0] = position[0] + 1;
					}
					position[2] = 1;
					position[3] = 0;
					map[position[0]][position[1]] = "v";
				} else if (s.equals("L")) {
					if (position[1] - 1 >= 0 && map[position[0]][position[1] - 1].equals(".")) {
						map[position[0]][position[1]] = ".";
						position[1] = position[1] - 1;
					}
					position[2] = 0;
					position[3] = -1;
					map[position[0]][position[1]] = "<";
				} else if (s.equals("R")) {
					if (position[1] + 1 < W && map[position[0]][position[1] + 1].equals(".")) {
						map[position[0]][position[1]] = ".";
						position[1] = position[1] + 1;
					}
					position[2] = 0;
					position[3] = 1;
					map[position[0]][position[1]] = ">";
				} else if (s.equals("S")) {
					int x = position[0] + position[2];
					int y = position[1] + position[3];

					while (y >= 0 && y < W && x >= 0 && x < H) {
						if (map[x][y].equals("*")) {
							map[x][y] = ".";
							break;
						} else if (map[x][y].equals("#")) {
							break;
						}
						x += position[2];
						y += position[3];
					}
				}
			}

			bw.write("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					bw.write(map[i][j] + "");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
