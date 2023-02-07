import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> nums = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			nums.add(i);
		}
		int idx = -1;
		while (nums.size() != 0) {
			idx = ((idx + K) % nums.size());
			answer.add(nums.get(idx));
			nums.remove(idx);
			idx--;
		}

		bw.write("<");
		for (int i = 0; i < answer.size(); i++) {
			if (i == answer.size() - 1)
				bw.write(answer.get(i) + ">");
			else
				bw.write(answer.get(i) + ", ");

		}
		bw.flush();
		bw.close();
	}
}
