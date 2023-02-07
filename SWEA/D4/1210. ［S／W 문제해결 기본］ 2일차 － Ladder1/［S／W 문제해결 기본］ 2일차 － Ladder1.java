import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(sc.nextLine());

			String[][] arr = new String[100][100];

			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextLine().split(" ");
			}
			int idx = -1;
			for (int i = 0; i < 100; i++) {
				if (arr[99][i].equals("2")) {
					idx = i;
				}
			}

			for (int i = 98; i > -1; i--) {
				if (idx > 0 && arr[i][idx - 1].equals("1")) {
					while (idx > 0 && arr[i][idx - 1].equals("1")) {
						idx -= 1;
					}
				} else if (idx < 99 && arr[i][idx + 1].equals("1")) {
					while (idx < 99 && arr[i][idx + 1].equals("1")) {
						idx += 1;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, idx);
		}
	}
}
