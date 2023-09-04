import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        List<Integer> counts = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++){
            // 작업 소요 일자 계산
            days[i] = ((100 - progresses[i]) % speeds[i] == 0) ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
        }
       
        int max = days[0];
        int count = 1;
        for(int i = 1; i < progresses.length; i++){
            // max보다 소요 일자가 작다면 한 번에 작업 가능
            if(max >= days[i]){
                count++;
            }
            // max보다 소요 일자가 크다면 새로 count
            else{
                counts.add(count);
                max = days[i];
                count = 1;
            }
        }
        counts.add(count);
        int[] answer = new int[counts.size()];
        for(int i = 0; i < counts.size(); i++){
            answer[i] = counts.get(i);
        }
        return answer;
     }
}