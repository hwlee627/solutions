package SWEA_1961;
// 숫자 배열 회전
// 변수를 이용하여 시작점을 설정하는 것을 도움
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			// 배열 입력
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			System.out.printf("#%d\n",test_case);
			
			// n을 이용하여 시작점 설정
			for (int n = N - 1; n >= 0; n--) {
				int r = 0;
				int c = N - n - 1;

				// 90도 회전
				for (r = N - 1; r >= 0; r--) {
					System.out.print(arr[r][c]);
				}
				System.out.printf(" ");

				// 180도 회전
				r = n;
				for (c = N - 1; c >= 0; c--) {
					System.out.print(arr[r][c]);
				}
				System.out.printf(" ");
				
				// 270도 회전
				c = n;
				for (r = 0; r < N; r++) {
					System.out.print(arr[r][c]);
				}
				System.out.println();
			}

		}

	}

}
