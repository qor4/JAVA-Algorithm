import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                String type = st.nextToken();
                if (clothes.containsKey(type)) {
                    clothes.put(type, clothes.get(type) + 1);
                } else {
                    clothes.put(type, 1);
                }
            }
            int answer = 1;
            for (String type : clothes.keySet()) {
                answer *= clothes.get(type)+1;
            }
            answer--;
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
