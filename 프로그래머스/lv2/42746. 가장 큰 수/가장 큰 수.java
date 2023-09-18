import java.util.*;
import java.math.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String num1, String num2){
                return Integer.parseInt(num2 + num1) - Integer.parseInt(num1 + num2);
            }
        });
        for(int i = 0; i < nums.length; i++){
            answer += nums[i];
        }
        return new BigInteger(answer).compareTo(new BigInteger("0")) == 0 ? "0" : answer;
    }
}