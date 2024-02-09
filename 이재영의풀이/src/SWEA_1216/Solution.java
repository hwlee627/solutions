package SWEA_1216;

// 회문2
// 회문 배열의 크기를 조정하면서 찾음
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			String[][] arr = new String[100][100];
			int max = 0;
			int N = sc.nextInt();
			for (int r = 0; r < 100; r++) {
				String[] str = sc.next().split("");
				for (int c = 0; c < 100; c++) {
					arr[r][c] = str[c];
				}
			}

			// 오른쪽으로 회문 찾기
			for (int r = 0; r < 100; r++) {
				for (int size = 2; size <= 100; size++) {
					String[] palindrome = new String[size];
					String[] compare = new String[size];
					for (int c = 0; c <= 100 - size; c++) {
						for (int i = 0; i < size; i++) {
							palindrome[i] = arr[r][c + i];
						}
						for (int i = 0; i < size; i++) {
							compare[i] = palindrome[size - 1 - i];
						}
						if (Arrays.equals(palindrome, compare)) {
							if (size > max) {
								max = size;
							}
						}
					}
				}
			}

			// 아래쪽으로 회문 찾기
			for (int c = 0; c < 100; c++) {
				for (int size = 2; size <= 100; size++) {
					String[] palindrome = new String[size];
					String[] compare = new String[size];
					for (int r = 0; r <= 100 - size; r++) {
						for (int i = 0; i < size; i++) {
							palindrome[i] = arr[r + i][c];
						}
						for (int i = 0; i < size; i++) {
							compare[i] = palindrome[size - 1 - i];
						}
						if (Arrays.equals(palindrome, compare)) {
							if (size > max) {
								max = size;
							}
						}
					}
				}
			}
			System.out.printf("#%d %d\n", N, max);
		}
	}
}