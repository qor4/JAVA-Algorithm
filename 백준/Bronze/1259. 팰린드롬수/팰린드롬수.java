import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String[] nums = sc.nextLine().split("");
			if (nums[0].equals("0"))
				break;
			List<String> list = new ArrayList<>(Arrays.asList(nums));
			List<String> list2 = new ArrayList<>(Arrays.asList(nums));
			Collections.reverse(list);
			if (list.equals(list2))
				System.out.println("yes");
			else
				System.out.println("no");

		}
	}
}