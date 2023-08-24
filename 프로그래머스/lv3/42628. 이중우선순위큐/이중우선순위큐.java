import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(String operation : operations){
            String[] op = operation.split(" ");
            if(op[0].equals("I")){
                min.add(Integer.parseInt(op[1]));
                max.add(Integer.parseInt(op[1]));
            }
            else if(!min.isEmpty() && op[0].equals("D") && op[1].equals("1")){
                int num = max.poll();
                min.remove(num);
                
            }
            else if(!min.isEmpty() && op[0].equals("D") && op[1].equals("-1")){
                int num = min.poll();
                max.remove(num);
            }
        }
        return min.isEmpty() ? new int[] {0, 0} : new int[] {max.poll(), min.poll()};
    }
}