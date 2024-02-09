package SWEA_1979;

// 어디에 단어가 들어갈 수 있을까
// 경계 조건 탐색으로 1이 얼마나 연속하는지 tmp에 저장하고 이를 K와 비교
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int cnt = 0;
			int tmp;
			
			// 배열 입력
			int[][] arr = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			// 오른쪽으로 1이 얼마나 연속하는지 세기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					tmp = 0;
					if (arr[r][c] == 1) {
						tmp = 1;
						while (c + 1 < N && arr[r][c + 1] == 1) {
							tmp++;
							c++;
						}
						if (tmp == K) {
							cnt++;
						}
					}
				}
			}
			
			// 아래쪽으로 1이 얼마나 연속하는지 세기
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++) {
					tmp = 0;
					if (arr[r][c] == 1) {
						tmp = 1;
						while (r + 1 < N && arr[r + 1][c] == 1) {
							tmp++;
							r++;
						}
						if (tmp == K) {
							cnt++;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, cnt);

		}

	}
}
