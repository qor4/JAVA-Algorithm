import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int cnt = 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            if((citations.length - i) >= citations[i]) {
                answer = citations[i];
                cnt = citations[i] + 1;
                while(i + 1 < citations.length && cnt < citations[i + 1]){
                if((citations.length - i - 1) >= cnt) {
                    answer = cnt;
                    cnt++;
                }
                else break;
            }
            }
            else{
                while(i + 1 < citations.length && cnt < citations[i + 1]){
                if((citations.length - i) >= cnt) {
                    answer = cnt;
                    cnt++;
                }
                else break;
            }
            }
            
        }
        return answer;
    }
}