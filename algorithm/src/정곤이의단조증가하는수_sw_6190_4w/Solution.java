package 정곤이의단조증가하는수_sw_6190_4w;

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
					boolean check = true;
					int num = numArr[i] * numArr[j];
//					System.out.println("num : "+num);
					String str = String.valueOf(num);
//					System.out.println("str : "+str);
					if (str.length() != 1) {
						for (int k = 0; k < str.length(); k++) {
							if (k + 1 < str.length()) {
								if (str.charAt(k) > str.charAt(k + 1)) {
//									System.out.println("num : " + num+" 브레이크");
									check = false;
									break;
								} else if (str.charAt(k) <= str.charAt(k + 1)) {
//									System.out.println("num : "+ num+ "elif");
								}
							}

						}
					} else {
						check = false;
					}
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