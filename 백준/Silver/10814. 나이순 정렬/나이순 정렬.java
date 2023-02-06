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

class User {
	int age;
	String name;
	int idx;
}

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		List<User> users = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			User user = new User();
			user.age = Integer.parseInt(st.nextToken());
			user.name = st.nextToken();
			users.add(user);
		}
		Collections.sort(users, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				if (o1.age == o2.age) {
					return o1.idx - o2.idx;
				} else {
					return o1.age - o2.age;
				}
			}
		});

		for (int i = 0; i < users.size(); i++) {
			bw.write(users.get(i).age + " " + users.get(i).name + "\n");
		}
		bw.flush();
		bw.close();

	}
}
