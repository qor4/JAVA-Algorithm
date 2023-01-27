import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String str = in.nextLine();
		for (int i = 97; i < 123; i++) {
			System.out.printf("%d ", str.indexOf((char) i));
		}
	}
}
