import java.util.*;
import java.io.*;

public class Main {
    static int V;
    static List[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < K; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new List[V + 1];
            for(int i = 0; i <= V; i++){
                graph[i] = new ArrayList<Integer>();
            }
            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }
            if(dfs()){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }

    private static boolean dfs() {
        int[] nodeType = new int[V + 1];
        for(int i = 1; i <= V; i++){
            Stack<int[]> stack = new Stack<>();
            if(nodeType[i] != 0) continue;
            stack.add(new int[]{i, 1});

            while(!stack.isEmpty()){
                int[] node = stack.pop();
                int n = node[0];
                int type = node[1];
                if(nodeType[n] == 0) nodeType[n] = type;
                else if(nodeType[n] == type) continue;
                else return false;
                for(int j = 0; j < graph[n].size(); j++){
                    stack.add(new int[]{(int) graph[n].get(j), type == 1 ? 2 : 1});
                }
            }

        }
        return true;
    }
}
