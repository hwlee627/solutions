package SWEA_7272;

// 안경이 없어
// 문자열 배열로 받고 구멍 수에 따라 숫자 배열로 전환하여 숫자 배열끼리 비교
// 문자열 배열의 한 문자에 대해서 B인지 우선 판별, one_hole 배열에 있는지 판별하고 모두 아닌 경우 구멍이 없다고 판별
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 문자열 배열 입력
			String[] X_arr = sc.next().split("");
			String[] Y_arr = sc.next().split("");
			
			// 정수형 배열 생성
			int[] X_int_arr = new int[X_arr.length];
			int[] Y_int_arr = new int[Y_arr.length];
			
			// 구멍이 하나 있는 문자들을 모은 배열
			String[] one_hole = { "A", "D", "O", "P", "Q", "R" };

			// 문자열 배열에 대해 구멍 수에 따라 정수형 배열로 전환
			for (int i = 0; i < X_arr.length; i++) {
				if (X_arr[i].equals("B")) {
					X_int_arr[i] = 2;
				} else if (Arrays.asList(one_hole).contains(X_arr[i])) {
					X_int_arr[i] = 1;
				} else {
					X_int_arr[i] = 0;
				}
			}
			for (int i = 0; i < Y_arr.length; i++) {
				if (Y_arr[i].equals("B")) {
					Y_int_arr[i] = 2;
				} else if (Arrays.asList(one_hole).contains(Y_arr[i])) {
					Y_int_arr[i] = 1;
				} else {
					Y_int_arr[i] = 0;
				}
			}
			
			// 배열 비교 후 출력
			if (Arrays.equals(X_int_arr, Y_int_arr)) {
				System.out.printf("#%d SAME\n", test_case);
			} else {
				System.out.printf("#%d DIFF\n", test_case);
			}

		}

	}
}