package SWEA_7236;

// 저수지의 물의 총 깊이 구하기
// 델타 배열을 이용하여 한 점을 기준으로 주변에 W 개수 세기
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String[][] arr = new String[N][N];
			int[] row = { 1, 1, 1, 0, 0, -1, -1, -1 };
			int[] col = { 1, 0, -1, 1, -1, -1, 0, 1 };
			int max = 0;
			
			// 배열 입력
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.next();
				}
			}
			
			// 델타 배열을 이용하여 주위 W 개수를 cnt에 저장하고 max와 비교
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cnt = 0;
					for (int i = 0; i < 8; i++) {
						int nr = r + row[i];
						int nc = c + col[i];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if (arr[nr][nc].equals("W")) {
								cnt++;
							}
						}
					}
					if (cnt > max) {
						max = cnt;
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, max);
		}

	}

}
