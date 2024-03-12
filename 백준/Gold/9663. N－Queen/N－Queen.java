import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = 0;
        Arrays.fill(arr, -1);
        nQueen(0);
        System.out.println(answer);
    }

    private static void nQueen(int depth) {
        if(depth == N){
            answer++;
            return;
        }
        for(int i = 0; i < N; i++){
            if(isPossible(depth, i)){
                arr[depth] = i;
                nQueen(depth + 1);
                arr[depth] = -1;
            }
        }
    }

    private static boolean isPossible(int depth, int col) {
        for(int i = 0; i < N; i++){
            if(arr[i] == -1) continue;
            if(arr[i] == col) return false;
            if((i - arr[i]) == (depth - col)) return false;
            if((i + arr[i]) == (depth + col)) return false;
        }
        return true;
    }
}
