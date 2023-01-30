import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		StringBuffer num1 = new StringBuffer(num[0]);
		StringBuffer num2 = new StringBuffer(num[1]);
		num1 = num1.reverse();
		num2 = num2.reverse();
		if (Integer.parseInt(num1.toString()) > Integer.parseInt(num2.toString()))
			System.out.println(num1);
		else
			System.out.println(num2);
	}
}
