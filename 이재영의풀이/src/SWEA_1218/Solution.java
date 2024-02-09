package SWEA_1218;

// 괄호짝짓기
// 열린 괄호를 만날 경우 경계조건탐색으로 닫힌 괄호를 만날 때까지 이동한다. 만날 경우 둘을 모두 공백으로 바꾸고, 최종적으로 모든 원소가 공백이 된다면 모두 짝이 지어진 것
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			// 한 줄을 입력받아 split으로 나눠서 arr에 저장
			String[] arr = sc.next().split("");
			boolean isCoupled = true; // 최종적으로 짝이 모두 지어졌는지 여부

			// 기본 순회는 i를 이용하고, 열린 괄호를 만날 경우 j를 통해 닫힌 괄호를 만날 때까지 이동 --> 만나면 i번째 괄호와 i+j번째 괄호를 ""으로 변경
			for (int i = 0; i < N; i++) {
				if (arr[i].equals("(")) {
					for (int j = 1; j < N - i; j++) {
						if (arr[i + j].equals(")")) {
							arr[i] = "";
							arr[i + j] = "";
							break;
						}
					}
				}
				if (arr[i].equals("[")) {
					for (int j = 1; j < N - i; j++) {
						if (arr[i + j].equals("]")) {
							arr[i] = "";
							arr[i + j] = "";
							break;
						}
					}
				}
				if (arr[i].equals("{")) {
					for (int j = 1; j < N - i; j++) {
						if (arr[i + j].equals("}")) {
							arr[i] = "";
							arr[i + j] = "";
							break;
						}
					}
				}
				if (arr[i].equals("<")) {
					for (int j = 1; j < N - i; j++) {
						if (arr[i + j].equals(">")) {
							arr[i] = "";
							arr[i + j] = "";
							break;
						}
					}
				}
			}
			// 최종적으로 arr 내부의 모든 원소가 ""이 되어야 true
			for (int i = 0; i < N; i++) {
				if (!arr[i].equals("")) {
					isCoupled = false;
				}
			}
			if(isCoupled) {
				System.out.printf("#%d 1\n",test_case);
			}else {
				System.out.printf("#%d 0\n",test_case);
			}

		}
	}
}