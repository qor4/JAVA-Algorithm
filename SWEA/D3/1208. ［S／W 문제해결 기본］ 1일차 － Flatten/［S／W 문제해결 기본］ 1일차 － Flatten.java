import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();

			int[] arr = new int[100];

			for (int i = 0; i < 100; i++) {
				arr[i]=sc.nextInt();
			}
			
			for (int i = 0; i < N; i++) {
				Arrays.sort(arr);
				arr[0] += 1;
				arr[arr.length-1] -= 1;
			}
			Arrays.sort(arr);
			System.out.printf("#%d %d\n", tc, arr[arr.length-1] - arr[0]);
		}
	}
}
