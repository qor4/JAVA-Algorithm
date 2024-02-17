import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Integer[] tmp = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            tmp[i] = nums[i];
        }
        Set<Integer> set = new HashSet<>(Arrays.asList(tmp));
        
        return Math.min((nums.length / 2), set.size());
    }
}