import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader 선언
		int N = Integer.parseInt(br.readLine()); // 검은 스카프의 수 입력 받음
		int[][] map = new int[102][102]; // 흰색 천의 역할을 할 배열 선언 (크기가 102인 이유는 0의 개수를 세는만큼 테두리를 추가하기 위함)
		for (int i = 0; i < N; i++) { // 검은 스카프의 수만큼 입력 받음
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 스페이스바로 구분되어 입력받는 것을 처리하기 위함
			int x = Integer.parseInt(st.nextToken()); // 검은 스카프의 왼쪽 변 사이 거리 입력
			int y = Integer.parseInt(st.nextToken()); // 검은 스카프의 아래쪽 변 사이 거리 입력
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[x + j + 1][y + k + 1] = 1; // 흰색 천에서 검은 스카프의 영역을 1로 표시
				}
			}
		}
		int cnt = 0; // 둘레를 구할 변수
		int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } }; // 현재 위치에서 상하좌우를 탐색하기 위한 변수
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (map[i][j] == 1) { // 검은 스카프일 때
					boolean flag = false; // 검은 스카프 내부가 아닌 테두리 부분인지 판단하기 위한 변수
					int zeroCnt = 0; // 주변에 흰색 천 영역이 많은지 셈(꼭짓점인지 구하기 위함)
					for (int[] d : dir) { // 상하좌우 탐색
						if (i + d[0] < 0 || i + d[0] >= 102 || j + d[1] < 0 || j + d[1] >= 102) // 만약 흰색천 범위를 벗어난다면 continue
							continue;
						if (map[i + d[0]][j + d[1]] == 0) { // 상하좌우중 흰색 천이 있다면
							zeroCnt++; // zero카운트 증가
							flag = true; // 흰색 천이 있다면 테두리이므로 flag = true
						}
					}
					if (flag) { // 테두리일 때
						cnt++; // 둘레 값 +
						if (zeroCnt >= 2) // 상하좌우로 흰색 천 부분이 2보다 크다면
							cnt++; // 꼭짓점이므로 추가로 둘레 값 +
					}
				}
			}
		}
		System.out.println(cnt); // 둘레의 길이 출력
	}
}
