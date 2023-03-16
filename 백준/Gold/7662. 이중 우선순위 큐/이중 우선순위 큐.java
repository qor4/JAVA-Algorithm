import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> t = new TreeMap<>();
			for (int i = 0; i < k; i++) {
				String[] ins = br.readLine().split(" ");
				if (ins[0].equals("I")) {
					t.put(Integer.parseInt(ins[1]), t.getOrDefault(Integer.parseInt(ins[1]), 0) + 1);
				} else if (ins[0].equals("D")) {
					if (t.isEmpty())
						continue;
					if (Integer.parseInt(ins[1]) == -1) {
						int min = t.firstKey();
						if (t.get(min) == 1) {
							t.remove(min);
						} else {
							t.put(min, t.get(min) - 1);
						}
					} else if (Integer.parseInt(ins[1]) == 1) {
						int max = t.lastKey();
						if (t.get(max) == 1) {
							t.remove(max);
						} else {
							t.put(max, t.get(max) - 1);
						}
					}
				}
			}
			if (t.isEmpty())
				bw.write("EMPTY\n");
			else
				bw.write(t.lastKey() + " " + t.firstKey() + "\n");
		}
		bw.flush();
		bw.close();
	}

}