import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int curHour = sc.nextInt();
        int curMin = sc.nextInt();
        int time = sc.nextInt();

        int endMin = (curMin + time) % 60;
        int endHour = (curHour + ((curMin + time) / 60)) % 24;

        System.out.println(endHour + " " + endMin);
    }
}
