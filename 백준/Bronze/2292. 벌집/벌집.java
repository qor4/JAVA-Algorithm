import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 1;
		N -= 1;
		while (N > 0) {
			N -= cnt * 6;
			cnt++;
		}
		System.out.println(cnt++);
	}
}
