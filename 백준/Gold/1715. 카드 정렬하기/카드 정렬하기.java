import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> a - b);
        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while(pq.size() > 1){
            int sum = pq.poll() + pq.poll();
            answer += sum;
            pq.add(sum);
        }
        System.out.println(answer);
    }
}
