import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		in.nextLine();
		String[] nums = in.nextLine().split("");

		int sum = 0;
		for (String num : nums) {
			sum += Integer.parseInt(num);
		}
		System.out.println(sum);
	}
}
