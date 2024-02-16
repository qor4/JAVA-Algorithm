import java.util.*;

class Solution {
    static int N;
    static List<String[]> answer;
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        answer = new ArrayList<>();
        int[] visited = new int[N];
        Stack<String> stack = new Stack<>();
        stack.add("ICN");
        searchAirport(0, stack, visited, tickets);
        Collections.sort(answer, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                for(int i = 0; i < o1.length; i++){
                    if(!o1[i].equals(o2[i])) return o1[i].compareTo(o2[i]);
                }
                return 0;
            }
        });
        return answer.get(0);
    }
    
    
    private static void searchAirport(int n, Stack<String> stack, int[] visited, String[][] tickets){
        if(n == N){
            answer.add(stack.toArray(new String[stack.size()]));
            return;
        }
        for(int i = 0; i < visited.length; i++){
            
            if(visited[i] == 0 && stack.peek().equals(tickets[i][0])){
                stack.push(tickets[i][1]);
                visited[i] = 1;
                searchAirport(n + 1, stack, visited, tickets);
                stack.pop();
                visited[i] = 0;
            }
        }
        
        return;
    }
}

