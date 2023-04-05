import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Integer> broken = new ArrayList<>();

		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				broken.add(Integer.parseInt(st.nextToken()));
			}
		}

		int cnt = Math.abs(N - 100);
		for (int i = 0; i < 1000000; i++) {
			boolean flag = true;
			for (String c : Integer.toString(i).split("")) {
				if (broken.contains(Integer.parseInt(c))) {
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt = Math.min(cnt, Integer.toString(i).length() + Math.abs(N - i));
			}

		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}
}