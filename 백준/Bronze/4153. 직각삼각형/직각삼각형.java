import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			if (x + y + z == 0)
				break;
			if (x * x + y * y == z * z || x * x + z * z == y * y || z * z + y * y == x * x)
				System.out.println("right");
			else
				System.out.println("wrong");
		}
	}
}
