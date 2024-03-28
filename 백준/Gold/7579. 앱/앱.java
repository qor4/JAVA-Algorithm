import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memorys = new int[N];
        int[] costs = new int[N];

        // 메모리 바이트 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memorys[i] = Integer.parseInt(st.nextToken());
        }
        // 비활성화 시 드는 비용
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N][10001];

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10001; j++) {
                if (i == 0) {
                    if (j >= costs[i]) dp[i][j] = memorys[i];
                }
                else{
                    if (j >= costs[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j - costs[i]] + memorys[i], dp[i - 1][j]);
                    } else dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][j] >= M) answer = Math.min(answer, j);
            }
        }
        System.out.println(answer);
    }


}