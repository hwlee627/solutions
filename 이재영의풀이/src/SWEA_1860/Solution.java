package SWEA_1860;

// 진기의 최고급 붕어빵
// 매초마다 생산되고 팔려나가는 붕어빵의 개수를 세면서 가능 여부를 판단
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			// 방문자 배열 입력
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int i = 0;
			int cnt = 0;
			int max = 0;
			
			// 가장 늦게 오는 손님이 몇 초인지 계산
			for (int j = 0; j < N; j++) {
				if (arr[j]>max) {
					max = arr[j];
				}
			}
			
			// 매초마다 붕어빵 개수를 추적하며 음수가 되면 impossible, 가장 늦게 오는 손님이 지나고서도 붕어빵 개수가 양수라면 possible 출력
			while (true) {

				if (i > 0 && i % M == 0) {
					cnt += K;
				}
				for (int j = 0; j < N; j++) {
					if (arr[j] == i) {
						cnt--;
					}
				}
				if (cnt < 0) {
					System.out.printf("#%d Impossible\n", test_case);
					break;
				}
				if (i > max) {
					System.out.printf("#%d Possible\n", test_case);
					break;
				}
				i++;
			}
		}
	}
}
