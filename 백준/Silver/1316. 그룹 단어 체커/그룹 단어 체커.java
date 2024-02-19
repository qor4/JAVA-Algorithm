import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        int answer = 0;
        for(int i = 0; i < n; i++){
            Arrays.fill(alphabet, 0);
            String word = br.readLine();
            boolean flag = true;
            for(int j = 0; j < word.length(); j++){
                if(alphabet[word.charAt(j) - 'a'] > 0 && word.charAt(j) != word.charAt(j - 1)){
                    flag = false;
                    break;
                }
                else alphabet[word.charAt(j) - 'a'] = alphabet[word.charAt(j) - 'a'] + 1;
            }
            if(flag) answer++;
        }
        System.out.println(answer);
    }
}
