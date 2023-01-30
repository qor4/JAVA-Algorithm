import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		String num = Integer.toString(A * B * C);
		int[] cnt = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < num.length(); i++) {
			cnt[num.charAt(i) - '0'] += 1;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(cnt[i]);
		}
	}
}
