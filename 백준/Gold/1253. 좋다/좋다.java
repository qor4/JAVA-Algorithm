import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int num = nums[i];
            int left = 0;
            int right = N - 1;
            while (right > left) {
                if (left == i) {
                    left++;
                    continue;
                } else if (right == i) {
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] > num) {
                    right--;
                } else if (nums[left] + nums[right] < num) {
                    left++;
                } else if (nums[left] + nums[right] == num) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }


}
