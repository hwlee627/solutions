package SWEA_1859;

// 백만장자프로젝트
// 
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			// 이익이 너무 커지는 경우를 대비하여 long으로 선언
			long profit = 0;

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			// 맨 뒷 값을 우선 tmp에 넣어줌
			int tmp = arr[N-1];
			// tmp가 그 앞 값보다 크다면, profit에 그 차이만큼 더해줌
			// 그렇지 않다면 tmp 갱신
			// 인덱스는 1까지만 비교
			for (int i = N - 1; i > 0; i--) {
				if(tmp>arr[i-1]) {
					profit+=(tmp-arr[i-1]);
				}else {
					tmp = arr[i-1];
				}
			}
			System.out.printf("#%d %d\n", test_case, profit);
		}
	}
}