import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			nums.add(sc.nextInt());
		}
		System.out.println(Collections.min(nums) + " " + Collections.max(nums));
	}
}
