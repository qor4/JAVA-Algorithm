import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int num1 = 1;
		int num2 = 1;
		for (int i = N; i > N - K; i--) {
			num1 *= i;
		}
		for (int i = K; i > 1; i--) {
			num2 *= i;
		}
		System.out.println(num1 / num2);
	}
}
