import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        for (int tc = 1; tc <= m; tc++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p1 = find(a);
            int p2 = find(b);
            if (flag == 0) {
                union(p1, p2);
            } else { // flag가 1일 때
                if (p1 == p2) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static void union(int a, int b) {
        parent[a] = b;
    }

    public static int find(int num) {
        if(parent[num] == num) return num;
        else return parent[num] = find(parent[num]);
    }
}
