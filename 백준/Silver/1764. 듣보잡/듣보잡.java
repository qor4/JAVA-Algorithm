import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Boolean> list1 = new HashMap<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list1.put(br.readLine(), true);
        }
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (list1.containsKey(s))
                list2.add(s);
        }
        Collections.sort(list2);
        bw.write(list2.size() + "\n");
        for (String n : list2) {
            bw.write(n + "\n");
        }
        bw.flush();
        bw.close();
    }
}
