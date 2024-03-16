import java.util.*;
import java.io.*;

class Number {
    int value;
    int idx;

    Number(int value, int idx){
        this.value = value;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Number> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            Number num = new Number(Integer.parseInt(st.nextToken()), i);
            while(!stack.isEmpty() && num.value > stack.peek().value){
                Number last = stack.pop();
                answer[last.idx] = num.value;
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            Number num = stack.pop();
            answer[num.idx] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int n : answer) {
            sb.append(n).append(' ');
        }
        System.out.println(sb);
    }
}
