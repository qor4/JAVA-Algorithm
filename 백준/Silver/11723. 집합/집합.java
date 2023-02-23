import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String m = st.nextToken();
			if (m.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				list.add(x);
			} else if (m.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				if (list.indexOf(x) != -1)
					list.remove(list.indexOf(x));
			} else if (m.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if (list.indexOf(x) != -1)
					bw.write("1\n");
				else
					bw.write("0\n");
			} else if (m.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if (list.indexOf(x) != -1)
					list.remove(list.indexOf(x));
				else
					list.add(x);
			} else if (m.equals("all")) {
				list.clear();
				for (int j = 1; j <= 20; j++) {
					list.add(j);
				}
			} else if (m.equals("empty")) {
				list.clear();
			}
		}
		bw.flush();
		bw.close();
	}
}