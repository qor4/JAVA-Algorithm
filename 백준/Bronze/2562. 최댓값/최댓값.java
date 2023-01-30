import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[9];
		for (int i = 0; i < 9; i++) {
			nums[i] = sc.nextInt();
		}
		int idx = 0;
		for (int i = 1; i < 9; i++) {
			if (nums[i] > nums[idx])
				idx = i;
		}
		System.out.println(nums[idx]);
		System.out.println(idx + 1);
	}
}
