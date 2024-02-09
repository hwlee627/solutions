package SWEA_2007;

// 패턴마디의길이
// 한 문자를 기준으로 오른쪽으로 몇 번 이동해야 같은 문자가 있는지 세고, 그 중 최댓값이 패턴의 길이가 됨
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			String[] str = sc.next().split("");
			int max = 0;

			// 문자열의 절반 이전의 인덱스에 대해 오른쪽으로 이동하며 시작점과 같은 문자가 몇번째에 있는지를 탐색
			// SAMSUNG과 같이 한 문자가 두 번 이상 등장할 경우에 대비하여 카운트의 최대값을 패턴 마디의 길이로 둠
			for (int i = 0; i < str.length/2; i++) {
				String alpha = str[i];
				int cnt = 0;

				for (int j = i; j < str.length - 1; j++) {
					cnt++;
					if (str[j + 1].equals(alpha)) {
						break;
					}
				}

				if (cnt > max) {
					max = cnt;
				}
			}
			System.out.printf("#%d %d\n", test_case, max);
		}
	}
}