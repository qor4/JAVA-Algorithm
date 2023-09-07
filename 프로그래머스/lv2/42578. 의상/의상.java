import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            if(clothesMap.containsKey(clothes[i][1])){
                clothesMap.put(clothes[i][1], clothesMap.get(clothes[i][1]) + 1);
            }
            else{
                clothesMap.put(clothes[i][1], 1);
            }
        }
        
        int answer = 1;
        for(String type : clothesMap.keySet()){
            answer *= clothesMap.get(type) + 1;
        }
        return answer - 1;
    }

}