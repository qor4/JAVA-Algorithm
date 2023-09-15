import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        for(int i = 0; i < numbers.length; i++){
            List<Integer> nums = new ArrayList(queue);
            queue.clear();
            for(int j = 0; j < nums.size(); j++){
                queue.add(nums.get(j) + numbers[i]);
                queue.add(nums.get(j) - numbers[i]);
            } 
        }
        for(int num : queue){
            if(num == target) answer++;
        }
        return answer;
    }
}