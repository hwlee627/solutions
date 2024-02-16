package SWEA_1493_수의새로운연산_2w;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			//#(&(N) + &(M))
			int[] A = getXY(N);
			int[] B = getXY(M);
			
			int X = A[0]+B[0];
			int Y = A[1]+B[1];
			
			int cnt = count(X,Y);
		
			System.out.println("#"+test_case+" "+cnt);
		}
	}
	public static int[] getXY(int num) {
		int sum = 0;
		int sum2 = 0;
		int order = 0;
		int X = 0;
		int Y = 0;
		
		int [] XY = new int [2];
		for(int i = 1; i<Integer.MAX_VALUE; i++) {
			sum += i;
			if(num <= sum) {
				order = i;
				break;
			}
		}
		for(int i = 0; i<=order-1; i++) {
			sum2 += i;
		}
		//X좌표와 Y좌표의 합은 order + 1 이므로
		X = num - sum2;
		Y = (order+1) - X;
		XY[0] = X;
		XY[1] = Y;
		return XY;
	}
	public static int count(int X, int Y) {
		int a = 0;
		int b = 0;
		int cnt = 0;
		boolean find = false;
		for(int sum = 2; ; sum++ ) {
			for(int i = 1; i<=sum-1; i++) {
				a = i;
				b = sum-a;
				cnt ++;
				if(a == X && b == Y) {
					find = true;
					break;
				}
			}
			if(find) {
				break;
			}
		}
		return cnt;
	}
}
