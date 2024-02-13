package SWEA_1289;

// 원재의메모리복구하기
// 기본적으로 값이 한 번 달라질 때마다 작업을 1회 해야하고, 스타트가 1일 시엔 작업을 1회하고 시작해야 함
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력을 문자열로 받아서 split으로 나누고 parseInt로 정수형으로 변경
			String[] str = sc.next().split("");
			int N = str.length;
			int cnt = 0;
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}

			// 배열을 순회하면서 값이 변경될 경우 카운트++
			for (int i = 0; i < N - 1; i++) {
				if (arr[i] != arr[i + 1]) {
					cnt++;
				}
			}

			// 만약 첫 시작이 1이라면 처음에 1로 덮어씌우고 시작해야하므로 카운트 +1
			if (arr[0] == 1) {
				cnt++;
			}
			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}
}