import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] time = new int[100001];
        boolean[] visited = new boolean[100001];
        Arrays.fill(time, Integer.MAX_VALUE);
        Arrays.fill(visited, true);
        time[N] = 0;
        visited[N] = false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            if (cur * 2 <= 100000 && visited[cur * 2]) {
                time[cur * 2] = time[cur];
                visited[cur * 2] = false;
                if (cur * 2 == K) break;
                queue.add(cur * 2);
            }
            if (cur - 1 >= 0 && visited[cur - 1]) {
                time[cur - 1] = time[cur] + 1;
                visited[cur - 1] = false;
                if (cur - 1 == K) break;
                queue.add(cur - 1);
            }
            if (cur + 1 <= 100000 && visited[cur + 1]) {
                time[cur + 1] = time[cur] + 1;
                visited[cur + 1] = false;
                if (cur + 1 == K) break;
                queue.add(cur + 1);
            }
        }
        System.out.println(time[K]);
    }

}
