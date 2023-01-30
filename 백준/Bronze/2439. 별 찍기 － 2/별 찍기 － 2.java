import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String star = "*";
		String space = "";
		for (int i = 0; i < num; i++) {
			space += " ";
		}
		for (int i = 0; i < num; i++) {
			System.out.println(space.substring(i + 1) + star);
			star += "*";
		}
	}
}
