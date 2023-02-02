import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i < N; i++) {
			String[] list = String.valueOf(i).split("");
			int M = i;
			for (String num : list) {
				M += Integer.parseInt(num);
			}
			if (M == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}