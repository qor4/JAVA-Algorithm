
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] numbers, input, selected;
	static int win, lose;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			win = 0;
			lose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			numbers = new int[9];
			input = new int[9];
			selected = new int[19];
			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				selected[num] = 1;
				input[i] = num;
			}

			perm(0);
			bw.write("#" + tc + " " + lose + " " + win + "\n");
		}
		bw.flush();
		bw.close();

	}

	private static void perm(int cnt) {
		// TODO Auto-generated method stub
		if (cnt == 9) {
			int score1 = 0;
			int score2 = 0;

			for (int i = 0; i < 9; i++) {
				if (input[i] > numbers[i])
					score1 += (input[i] + numbers[i]);
				else if (input[i] < numbers[i])
					score2 += (input[i] + numbers[i]);
			}
			if (score1 > score2)
				lose++;
			else if (score2 > score1)
				win++;
			return;
		}
		for (int i = 1; i < 19; i++) {
			if (selected[i] == 1 || selected[i] == 2)
				continue;
			selected[i] = 2;
			numbers[cnt] = i;
			perm(cnt + 1);
			selected[i] = 0;
		}
	}

}
