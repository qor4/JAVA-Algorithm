import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> wordsSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			wordsSet.add(br.readLine());
		}
		List<String> wordsList = new ArrayList<>(wordsSet);
		Collections.sort(wordsList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});

		for (int i = 0; i < wordsList.size(); i++) {
			bw.write(wordsList.get(i) + "\n");
		}
		bw.flush();
		bw.close();

	}
}
