import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        HashMap<Character, Integer> alphabet = new HashMap<>();
        alphabet.put('A', 0);
        alphabet.put('E', 1);
        alphabet.put('I', 2);
        alphabet.put('O', 3);
        alphabet.put('U', 4);
        int[] count = new int[] {781, 156, 31, 6, 1};
        
        for(int i = 0; i < word.length(); i++){
            answer += count[i] * alphabet.get(word.charAt(i)) + 1;
        }
        
        return answer;
    }
}