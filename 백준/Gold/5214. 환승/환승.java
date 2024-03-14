import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int K;
    static int M;
    static int answer;
    static int[][] hypertubes;
    static List<Integer>[] stations;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hypertubes = new int[M][K];
        stations = new List[N + 1];
        for(int i = 0; i <= N; i++){
            stations[i] = new ArrayList<>();
        }
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < K; j++) {
                int n = Integer.parseInt(st.nextToken());
                hypertubes[i][j] = n;
                stations[n].add(i);
            }
        }
        bfs();
        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        boolean[] sVisited = new boolean[N + 1];
        boolean[] hVisited = new boolean[M];
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int num = node[0];
            int cnt = node[1];
            sVisited[num] = true;

            if (num == N) {
                answer = Math.min(answer, cnt);
            }

            for(int i = 0; i < stations[num].size(); i++){
                if(hVisited[stations[num].get(i)]) continue;
                int[] hypertube = hypertubes[stations[num].get(i)];
                hVisited[stations[num].get(i)] = true;
                for(int j = 0; j < K; j++){
                    if (sVisited[hypertube[j]]) continue;
                    queue.add(new int[]{hypertube[j], cnt + 1});
                    sVisited[hypertube[j]] = true;
                }
            }
        }
    }


}
