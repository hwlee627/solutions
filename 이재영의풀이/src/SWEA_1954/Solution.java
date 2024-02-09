package SWEA_1954;

// 달팽이 숫자
// 시계 방향으로 채워지는 것에 착안하여 우,하,좌,상 순서로 채우고 배열이 다 채워졌는지 확인함
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int r = 0, c = 0;
			int cnt = 1;
			arr[r][c] = cnt;
			boolean isRepeat = true;

			// 우,하,좌,상 순서로 채우기
			while (isRepeat) {
				while (c + 1 < N && arr[r][c + 1] == 0) {
					arr[r][++c] = ++cnt;
				}
				while (r + 1 < N && arr[r + 1][c] == 0) {
					arr[++r][c] = ++cnt;
				}
				while (c - 1 >= 0 && arr[r][c - 1] == 0) {
					arr[r][--c] = ++cnt;
				}
				while (r - 1 >= 0 && arr[r - 1][c] == 0) {
					arr[--r][c] = ++cnt;
				}

				isRepeat = false;

				// 배열에 0이 있는지 확인
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (arr[i][j] == 0) {
							isRepeat = true;
							break;
						}
					}
				}
			}

			System.out.printf("#%d\n", N);
			for (int[] x : arr) {
				for (int y : x) {
					System.out.printf("%d ", y);
				}
				System.out.println();
			}
		}
	}
}
