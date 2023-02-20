import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		HashMap<String, Integer> dictionary = new HashMap<>();
		HashMap<Integer, String> dictionary2 = new HashMap<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			dictionary.put(name, i);
			dictionary2.put(i, name);
		}
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			try {
				bw.write(dictionary2.get(Integer.parseInt(input)) + "\n");
			} catch (Exception e) {
				bw.write(dictionary.get(input) + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}