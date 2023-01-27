import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Set<Integer> nums = new HashSet<Integer>();

		for (int i = 0; i < 10; i++) {
			nums.add(in.nextInt() % 42);
		}
		System.out.println(nums.size());
	}
}
