import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();

			String answer = "";
			if (N % H == 0) {
				answer += H;
				if (N / H < 10)
					answer = answer + "0" + (N / H);
				else
					answer += (N / H);
			} else {
				answer += N % H;
				if (N / H + 1 < 10)
					answer = answer + "0" + (N / H + 1);
				else
					answer += (N / H + 1);
			}

			System.out.println(answer);
		}
	}
}