package SWEA_1940;

// 가랏RC카
// 현재 속도를 나타내는 변수를 선언하여 커맨드에 맞게 바꿈
// 속도 단위가 m/s이므로 스피드를 그대로 더해주면 됨
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int dist = 0;
			int speed = 0;

			// 현재 속도를 나타내는 speed를 바꿔가며 반복문 마지막에는 dist에 speed만큼 더해줌
			for (int i = 0; i < N; i++) {
				int command = sc.nextInt();

				if (command == 1) {
					int change = sc.nextInt();
					speed += change;
				} else if (command == 2) {
					int change = sc.nextInt();
					if (change > speed) {
						speed = 0;
					} else {
						speed -= change;
					}
				}
				dist += speed;
			}
			System.out.printf("#%d %d\n", test_case, dist);
		}
	}
}