package SWEA_1493;

// 수의 새로운 연산
// x좌표가 1이 되는 지점이 계차수열을 따르는 점을 이용하여 일반항을 만들고 함수로 구현
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			System.out.printf("#%d %d\n", test_case, star(num1, num2));
		}

	}

	// 두 점을 받아 수를 할당해주는 함수
	// 두 수의 합에서 1을 뺸 값을 n이라고 하면, x는 (n^2-n+2)/2에서 다시 1부터 시작하게 됨
	public static int pointToNum(int x, int y) {
		int n = x + y - 1;
		return (int) ((Math.pow(n, 2) - n + 2) / 2 + x - 1);
	}

	// 위 함수의 역과정
	// 주어진 값과 가장 가까운 n값을 먼저 찾고 x,y를 구함
	public static int[] NumToPoint(int N) {
		int n = 1;
		while ((Math.pow(n, 2) - n + 2) / 2 <= N) {
			n++;
		}
		n--;
		int x = (int) (N + 1 - (Math.pow(n, 2) - n + 2) / 2);
		int y = n - x + 1;
		int[] result = { x, y };
		return result;
	}

	// 별 연산에 맞게 두 수를 나타내는 좌표를 각각 더한 후 다시 수로 바꿔줌
	public static int star(int num1, int num2) {

		int x1 = NumToPoint(num1)[0] + NumToPoint(num2)[0];
		int y1 = NumToPoint(num1)[1] + NumToPoint(num2)[1];
		return pointToNum(x1, y1);
	}
}