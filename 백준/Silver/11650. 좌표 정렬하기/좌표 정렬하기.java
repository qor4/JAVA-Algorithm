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

class Coor {
	int x;
	int y;
}

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Coor> coors = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Coor c = new Coor();
			c.x = Integer.parseInt(st.nextToken());
			c.y = Integer.parseInt(st.nextToken());
			coors.add(c);
		}
		Collections.sort(coors, new Comparator<Coor>() {
			@Override
			public int compare(Coor o1, Coor o2) {
				if (o1.x == o2.x) {
					return o1.y - o2.y;
				}
				return o1.x - o2.x;
			}
		});
		for (int i = 0; i < coors.size(); i++) {
			bw.write(coors.get(i).x + " " + coors.get(i).y + "\n");
		}
		bw.flush();
		bw.close();
	}

}
