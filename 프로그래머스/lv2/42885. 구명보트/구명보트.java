import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int minIdx = 0;
        int maxIdx = people.length - 1;
        
        Arrays.sort(people);
        while(maxIdx >= minIdx){
            if(people[maxIdx] + people[minIdx] > limit){
                maxIdx--;
            } else{
                maxIdx--;
                minIdx++;
            }
            answer++;
        }
        return answer;
    }
}