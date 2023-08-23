import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }
            else{
                stack.push(charArr[i]);
            }
        }
        if(!stack.isEmpty()){
            answer = false;
        }
        return answer;
    }
}