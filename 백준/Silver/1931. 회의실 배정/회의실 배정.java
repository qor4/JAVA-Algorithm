import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Meeting {
	int s;
	int e;

	public Meeting(int s, int e) {
		super();
		this.s = s;
		this.e = e;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(s, e);
		}

		Arrays.sort(meetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting o1, Meeting o2) {
				// TODO Auto-generated method stub
				return o1.e == o2.e ? o1.s - o2.s : o1.e - o2.e;
			}
		});
		int ans = 0;
		int current = 0;
		for (Meeting m : meetings) {
			if (m.s >= current) {
				ans++;
				current = m.e;
			}
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
	}

}
