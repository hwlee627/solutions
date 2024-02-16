package SWEA_6190_정곤이의단조증가하는수_4w;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int numCnt = sc.nextInt();
			int[] numArr = new int[numCnt];
			for (int i = 0; i < numCnt; i++) {
				numArr[i] = sc.nextInt();
			}

			int max = 0;
			for (int i = 0; i < numCnt - 1; i++) {
				for (int j = i + 1; j < numCnt; j++) {
					//boolean으로 단조인지 아닌지 판별
					boolean check = true;
					//수 두개를 고른 후 num 변수에 넣어
					int num = numArr[i] * numArr[j];

					//String으로 변환(크기 비교 하기 위함)
					String str = String.valueOf(num);
					
					//숫자가 한 자리 수 이면 단조를 판별 할 수 없으므로 제외시킴
					if (str.length() != 1) {
						for (int k = 0; k < str.length(); k++) {
							if (k + 1 < str.length()) {
								//한 인덱스값을 기준으로 뒤의 숫자와 비교
								//커지지않고 작아지는 부분이 있다면 판별 boolean을 false로 설정
								if (str.charAt(k) > str.charAt(k + 1)) {

									check = false;
									break;
								} else if (str.charAt(k) <= str.charAt(k + 1)) {

								}
							}

						}
						//숫자가 한 자리수 인 경우 false
					} else {
						check = false;
					}
					//단조인 수들 중 최대값 구하기
					if(check) {
						num = Integer.parseInt(str);
						if (max < num) {
							max = num;
						}
					}

				}
			}
			if (max != 0) {
				System.out.println("#" + test_case + " " + max);
			} else {
				System.out.println("#" + test_case + " -1");
			}
			System.out.println();

		}
	}
}