import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < T; i++) {
			int R = sc.nextInt();
			String str = sc.nextLine().trim();
			String answer = "";

			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < R; k++) {
					answer += str.charAt(j);
				}
			}
			System.out.println(answer);
		}
	}
}
