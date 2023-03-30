import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().replaceAll("\\[|\\]", "").split(",");
			int start = 0;
			int end = n;
			boolean reverse = true;
			boolean flag = true;
			for (char c : p) {
				if (c == 'R') {
					reverse = !reverse;
				}
				if (c == 'D') {
					if (start == end) {
						bw.write("error\n");
						flag = false;
						break;
					}
					if (reverse) {
						start++;
					} else {
						end--;
					}
				}
			}
			if (flag) {
				arr = Arrays.copyOfRange(arr, start, end);
				List<String> list = Arrays.asList(arr);
				if (!reverse)
					Collections.reverse(list);
				bw.write(list.toString().replace(" ", "") + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
