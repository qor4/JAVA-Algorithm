import java.util.*;
import java.io.*;

public class Main {
    static int N, R, answer;
    static int[] team1;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = N / 2;
        answer = Integer.MAX_VALUE;
        team1 = new int[R];
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(answer);
    }

    public static void comb(int cnt, int start) {
        if (cnt == R) {
            boolean[] team = new boolean[N];
            for (int num : team1) {
                team[num] = true;
            }
            int[] team2 = new int[R];
            int idx = 0;
            for (int i = 0; i < N; i++) {
                if (!team[i]) {
                    team2[idx] = i;
                    idx++;
                }
            }
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < R - 1; i++) {
                for (int j = i + 1; j < R; j++) {
                    sum1 += arr[team1[i]][team1[j]];
                    sum1 += arr[team1[j]][team1[i]];
                    sum2 += arr[team2[i]][team2[j]];
                    sum2 += arr[team2[j]][team2[i]];
                }
            }
            answer = Math.min(answer, Math.abs(sum1 - sum2));
            return;
        }
        for (int i = start; i < N; i++) {
            team1[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }
}
