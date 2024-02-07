package SWEA_4613_러시아국기같은깃발;

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
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			
			char[][] flag = new char[N][M];
			int colored = 0;
			int min = Integer.MAX_VALUE;
			for(int r=0; r<N; r++) {
				String str = sc.next();
				for(int c=0; c<M; c++) {
					flag[r][c] = str.charAt(c);
				}
			}
//			for(int r=0; r<N; r++) {
//				for(int c=0; c<M; c++) {
//					System.out.print(flag[r][c]);
//				}
//				System.out.println();
//			}
			
//			for(int c = 0; c<M; c++) {
//				if(flag[0][c] != 'W') {
//					flag[0][c] = 'W';
//					colored++;
//				}
//			}
//			
//			for(int c = 0; c<M; c++) {
//				if(flag[N-1][c]!='R') {
//					flag[N-1][c] = 'R';
//					colored++;
//				}
//			}
			int cnt = 0;
			for(int w = 1; w<=N-2; w++) {
				for(int b = 1; b<N-w; b++) {
					int red = N-w-b;
					cnt = 0;
					for(int r = 0; r<N; r++) {
						if(r<=(w-1)) {
							for(int c = 0; c<M; c++) {
								if(flag[r][c] != 'W') {
									cnt++;
								}
							}
						}else if((w-1)<r && r<(N-red)) {
							for(int c = 0; c<M; c++) {
								if(flag[r][c] != 'B') {
									
									cnt++;
								}
							}
						}else {
							for(int c = 0; c<M; c++) {
								if(flag[r][c] != 'R') {
									
									cnt++;
								}
							}
						}
					}
					if(min > cnt) {
						min = cnt;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+min);
		}
	}
}
