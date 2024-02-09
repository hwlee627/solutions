package SWEA_6485;

// 삼성시의버스노선
// 0으로 가득찬 배열에 a-1부터 b-1까지의 인덱스에 1씩 추가
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			// 버스정류장 배열 생성
			int[] cnt = new int[5000];
			// 노선 시작점, 끝점을 a,b로 받아 a-1부터 b-1인덱스까지 카운트 배열++
			for (int i = 0; i < N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				for (int j = a - 1; j <= b - 1; j++) {
					cnt[j]++;
				}
			}
			int P = sc.nextInt();
			System.out.printf("#%d ", test_case);
			for (int i = 0; i < P; i++) {
				int idx = sc.nextInt();
				System.out.printf("%d ", cnt[idx - 1]); // 인덱스-1에 주의
			}
			System.out.println();
		}

	}

}