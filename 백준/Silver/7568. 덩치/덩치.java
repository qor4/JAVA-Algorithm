import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Person {
	int height;
	int weight;
}

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Person c = new Person();
			c.weight = Integer.parseInt(st.nextToken());
			c.height = Integer.parseInt(st.nextToken());
			persons.add(c);
		}

		for (int i = 0; i < persons.size(); i++) {
			int cnt = 0;
			for (int j = 0; j < persons.size(); j++) {
				if (i == j)
					continue;
				if ((persons.get(i).height < persons.get(j).height)
						&& (persons.get(i).weight < persons.get(j).weight)) {
					cnt++;
				}
			}
			bw.write(cnt + 1 + " ");
		}
		bw.flush();
		bw.close();
	}

}
