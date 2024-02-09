package SWEA_11315;

// 오목 판정
// 경계 조건 탐색으로 카운트 개수 확인
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String[][] arr = new String[N][N];
			boolean isFive = false;

			// 배열 입력
			for (int r = 0; r < N; r++) {
				String[] str = sc.next().split("");
				for (int c = 0; c < N; c++) {
					arr[r][c] = str[c];
				}
			}

			// 아래로 확인
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cnt = 0;
					if (arr[r][c].equals("o")) {
						cnt = 1;
						int nr = r + 1;
						while (nr < N && arr[nr][c].equals("o")) {
							nr += 1;
							cnt++;
						}
						if (cnt >= 5) {
							isFive = true;
						}
					}
				}
			}
			
			// 오른쪽으로 확인
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cnt = 0;
					if (arr[r][c].equals("o")) {
						cnt = 1;
						int nc = c + 1;
						while (nc < N && arr[r][nc].equals("o")) {
							nc += 1;
							cnt++;
						}
						if (cnt >= 5) {
							isFive = true;
						}
					}
				}
			}
			
			// 오른쪽 아래 대각선으로 확인
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cnt = 0;
					if (arr[r][c].equals("o")) {
						cnt = 1;
						int nr = r + 1;
						int nc = c + 1;
						while (nc < N && nr < N && arr[nr][nc].equals("o")) {
							nc += 1;
							nr += 1;
							cnt++;
						}
						if (cnt >= 5) {
							isFive = true;
						}
					}
				}
			}
			
			// 왼쪽 아래 대각선으로 확인
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cnt = 0;
					if (arr[r][c].equals("o")) {
						cnt = 1;
						int nr = r + 1;
						int nc = c - 1;
						while (nc >= 0 && nr < N && arr[nr][nc].equals("o")) {
							nc -= 1;
							nr += 1;
							cnt++;
						}
						if (cnt >= 5) {
							isFive = true;
						}
					}
				}
			}
			
			// 판별 후 출력
			if (isFive) {
				System.out.printf("#%d YES\n", test_case);
			} else {
				System.out.printf("#%d NO\n", test_case);
			}

		}

	}

}
