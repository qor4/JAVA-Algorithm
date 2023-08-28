import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            pq.offer(priorities[i]);
            queue.add(new int[]{priorities[i], i});
        }
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            if(node[0] == pq.peek()){
                pq.poll();
                answer++;
                if(node[1]==location){
                    break;
                }
            }
            else{
                queue.add(node);
            }
        }
        return answer;
    }
}