import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[] cnt = new int[4];
		int answer = 0;
		String[] subStr = str.substring(0, P).split("");
		for (String s : subStr) {
			switch (s) {
			case "A":
				cnt[0]++;
				break;
			case "C":
				cnt[1]++;
				break;
			case "G":
				cnt[2]++;
				break;
			case "T":
				cnt[3]++;
				break;
			}
		}
		if (cnt[0] >= A && cnt[1] >= C && cnt[2] >= G && cnt[3] >= T)
			answer++;
		for (int i = 0; i < S - P; i++) {
			char s = str.charAt(i);
			switch (s) {
			case 'A':
				cnt[0]--;
				break;
			case 'C':
				cnt[1]--;
				break;
			case 'G':
				cnt[2]--;
				break;
			case 'T':
				cnt[3]--;
				break;
			}
			s = str.charAt(i + P);
			switch (s) {
			case 'A':
				cnt[0]++;
				break;
			case 'C':
				cnt[1]++;
				break;
			case 'G':
				cnt[2]++;
				break;
			case 'T':
				cnt[3]++;
				break;
			}

			if (cnt[0] >= A && cnt[1] >= C && cnt[2] >= G && cnt[3] >= T)
				answer++;
		}

		bw.write(answer + "");
		bw.flush();
		bw.close();

	}
}
