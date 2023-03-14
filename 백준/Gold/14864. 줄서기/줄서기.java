import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] students = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			students[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			students[s1]++;
			students[s2]--;
		}
		int[] tmp = students.clone();
		Arrays.sort(tmp);
		boolean flag = true;
		for (int i = 0; i < N + 1; i++) {
			if (tmp[i] != i) {
				flag = false;
				break;
			}
		}
		if (flag) {
			for (int i = 1; i < N + 1; i++) {
				bw.write(students[i] + " ");
			}
		} else {
			bw.write("-1");
		}
		bw.flush();
		bw.close();
	}

}
