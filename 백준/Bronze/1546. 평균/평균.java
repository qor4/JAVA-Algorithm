import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> scores = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			scores.add(num);
		}

		int max = Collections.max(scores);
		double sum = 0;
		for (int i = 0; i < scores.size(); i++) {
			sum += (double) scores.get(i) / max * 100;
		}
		System.out.println(sum / scores.size());
	}
}
