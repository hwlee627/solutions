package SWEA_1215;

// 회문1
// 배열 일부를 요소로 가지는 배열과 그를 거꾸로 한 배열을 비교
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String[] palindrome = new String[N];
			String[] compare = new String[N];
			String[][] arr = new String[8][8];
			int cnt = 0;
			
			// 배열 입력
			for (int r = 0; r < 8; r++) {
				String[] str = sc.next().split("");
				for (int c = 0; c < 8; c++) {
					arr[r][c] = str[c];
				}
			}
			
			// 아래 방향으로 회문 찾기
			for (int r = 0; r < 8; r++) {
				for (int c = 0; c <= 8 - N; c++) {
					for (int i = 0; i < N; i++) {
						palindrome[i] = arr[r][c + i];
					}
					for (int i = 0; i < N; i++) {
						compare[i] = palindrome[N - 1 - i];
					}
					if (Arrays.equals(palindrome, compare)) {
						cnt++;
					}
				}
			}
			
			// 오른쪽 방향으로 회문 찾기
			for (int c = 0; c < 8; c++) {
				for (int r = 0; r <= 8 - N; r++) {
					for (int i = 0; i < N; i++) {
						palindrome[i] = arr[r + i][c];
					}
					for (int i = 0; i < N; i++) {
						compare[i] = palindrome[N - 1 - i];
					}
					if (Arrays.equals(palindrome, compare)) {
						cnt++;
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}
}