import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> tmpAnswer = new ArrayList<>();
        HashMap<String, Integer> sumPlays = new HashMap<>();
        HashMap<String, List<int[]>> play = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            if(!sumPlays.containsKey(genres[i])){
                sumPlays.put(genres[i], 0);
                play.put(genres[i], new ArrayList<>());
            }
            play.get(genres[i]).add(new int[]{i, plays[i]});
            sumPlays.put(genres[i], sumPlays.get(genres[i])+plays[i]);
        }
        // sumPlays를 value 기준으로 정렬
        List<Map.Entry<String, Integer>> sortSumPlays = new ArrayList<>(sumPlays.entrySet()); 
        Collections.sort(sortSumPlays, new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue()); // 내림차순
            }
        });
        
        // play의 List를 int[1] 기준으로 정렬
        for(int i = 0; i < sortSumPlays.size(); i++){
            String genre = sortSumPlays.get(i).getKey();
            Collections.sort(play.get(genre), new Comparator<>(){
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1]; // 내림차순
                }
            });
            for(int j = 0; j < play.get(genre).size(); j++){
                if(j > 1) break;
                tmpAnswer.add(play.get(genre).get(j)[0]);
            }
            
        }
        int[] answer = new int[tmpAnswer.size()];
        for(int i = 0; i < tmpAnswer.size(); i++){
            answer[i] = tmpAnswer.get(i);
        }
        return answer;
    }
}