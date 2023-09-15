import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        
        String[] words = s.split(" ");
        for(String word : words){
            if(word.isBlank()){
                answer += " ";
                continue;
            }
            word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
            answer += word + " ";
        }
        if(s.charAt(s.length() - 1) != ' ') answer = answer.substring(0, answer.length() - 1);
        return answer;
    }
}