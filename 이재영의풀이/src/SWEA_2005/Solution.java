package SWEA_2005;

// 파스칼의삼각형
// 반복문의 시작에 기존 배열을 저장해줌으로써 현재 배열을 생성함에 있어 기존 배열의 값을 참조할 수 있게 함
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			// 첫번째 preArr에 넣어주기 위해 길이 1짜리 배열 생성
			int[] arr = new int[1];

			System.out.printf("#%d\n", test_case);
			
			// 이전 반복문을 통해 생성된 배열을 preArr에 저장하고 시작
			// i번째 배열에 대해 길이가 i, 첫값과 끝값이 1인 배열 생성
			// i>=3일 경우 배열의 j번째 값에 대해 이전 배열의 j-1, j번째 값을 더해서 구함
			for (int i = 1; i <= N; i++) {
				int[] preArr = arr;
				arr = new int[i];
				arr[0] = 1;
				arr[i - 1] = 1;
				if (i >= 3) {
					for (int j = 1; j <= i - 2; j++) {
						arr[j] = preArr[j - 1] + preArr[j];
					}
				}

				// 삼각형 출력
				for (int k = 0; k < i; k++) {
					System.out.printf("%d ", arr[k]);
				}
				System.out.println();
			}
		}
	}
}