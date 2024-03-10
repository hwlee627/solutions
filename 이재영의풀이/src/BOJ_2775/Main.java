package BOJ_2775;

// 부녀회장이될테야
// dp를 이용하여 값을 저장
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(dp(k, n - 1));
		}
	}

	static int[][] d = new int[15][15];

	static int dp(int k, int n) {
		if (k == 0) {
			return n + 1;
		}
		if (n == 0) {
			return 1;
		}
		if (d[k][n] != 0) {
			return d[k][n];
		}
		return d[k][n] = dp(k - 1, n) + dp(k, n - 1);
	}
}