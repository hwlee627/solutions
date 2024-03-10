package BOJ_15829;

// Hashing
// Math.pow를 쓰면 범위를 벗어나 오차 발생, 나머지의 성질을 이용해 직접 함수를 구현하여 계산
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		long sum = 0;
		String str = sc.next();
		for (int i = 0; i < L; i++) {
			char N = str.charAt(i);
			int n = N - 96;
			sum += n * pow(i) % 1234567891;
		}
		System.out.println(sum % 1234567891);
	}

	static long pow(int n) {
		long num = 1;
		for (int i = 0; i < n; i++) {
			num = num * 31 % 1234567891;
		}
		return num;
	}
}