import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Document {
    int idx;
    int imp;

    Document(int idx, int imp) {
        this.idx = idx;
        this.imp = imp;
    }
}

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            LinkedList<Document> printer = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {

                Document d = new Document(i, Integer.parseInt(st.nextToken()));
                printer.add(d);
            }

            int cnt = 0;
            while (true) {
                Document d = printer.poll();
                boolean state = true;
                for (int i = 0; i < printer.size(); i++) {
                    if (printer.get(i).imp > d.imp) {
                        printer.add(d);
                        state = false;
                        break;
                    }
                }
                if (state) {
                    cnt++;
                    if (d.idx == M) {
                        bw.write(cnt + "\n");
                        break;
                    }
                }

            }

        }
        bw.flush();
        bw.close();
    }
}
