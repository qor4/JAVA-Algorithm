import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 최대 이동 횟수
        
        for(int i = 0; i < name.length(); i++){
            // 각 알파벳을 만들기 위한 조작 횟수 최소값
            answer += Math.min(Math.abs('A' - name.charAt(i)), Math.abs('Z' - name.charAt(i) + 1));
            
            // A의 마지막 위치
            int idx = i + 1;
            while(idx < name.length() && name.charAt(idx) =='A'){
                idx++;
            }
            
			// 좌우이동
            move = Math.min(move, i + (name.length() - idx) + Math.min(i, name.length() - idx));
        }
        
        return answer + move;
    }
}