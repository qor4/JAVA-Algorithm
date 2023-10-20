import java.util.*;
class Solution {
    static boolean[] visited;
    static List<Integer> numList;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        numList = new ArrayList<>();
        for(int i = 1; i <= numbers.length(); i++){
            int[] output = new int[i];
            perm(0, i, numbers, output);
        }
        return numList.size();
    }
    
    public void perm(int cnt, int N, String numbers, int[] output){
        if(cnt == N){
            String[] strArr = new String[N];
            for (int i = 0; i < N; i++) {
                strArr[i] = String.valueOf(output[i]);
            } 
            int num = Integer.parseInt(String.join("", strArr));
            if(isPrime(num)){
                if(!numList.contains(num)) numList.add(num);
            }
            return;
        }
        for(int i = 0; i < numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            output[cnt] = numbers.charAt(i) - '0';
            perm(cnt + 1, N, numbers, output);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}