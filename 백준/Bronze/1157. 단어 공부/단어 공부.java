import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();
		
		int[] cnt = new int[26];
		Arrays.fill(cnt, 0);
		
		for (int i = 0; i < str.length(); i++) {
			cnt[str.charAt(i) - 'A'] += 1;
		}
		
		int idx = 0;
		for (int i = 1; i < cnt.length; i++) {
			if (cnt[idx] < cnt[i])
				idx = i;
		}
		
		int c = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[idx] == cnt[i])
				c++;
		}

		if (c > 1)
			System.out.print("?");
		else
			System.out.print((char) (idx + 'A'));
	}
}
