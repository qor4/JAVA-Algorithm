import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			int score = 0;
			int s = 0;
			for (int j = 0; j < str.length(); j++) {
				if (Character.toString(str.charAt(j)).equals("O")) {
					s += 1;
					score += s;
				} else {
					s = 0;
				}
			}
			System.out.println(score);
		}
	}
}
