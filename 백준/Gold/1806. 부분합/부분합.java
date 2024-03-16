import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;
        int sum = nums[0];
        while (right < N || sum >= S) {
            if (sum < S) {
                sum += nums[right];
                right++;
            } else {
                answer = Math.min(answer, right - left);
                sum -= nums[left];
                left++;
            }
        }
        if (answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);

    }
}