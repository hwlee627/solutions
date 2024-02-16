package SWEA_4613_러시아국기같은깃발_3w;

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
			
			//국기 색 배열 생성
			char[][] flag = new char[N][M];
			int colored = 0;
			int min = Integer.MAX_VALUE;
			for(int r=0; r<N; r++) {
				String str = sc.next();
				for(int c=0; c<M; c++) {
					flag[r][c] = str.charAt(c);
				}
			}
			int cnt = 0;
			//완전탐색 돌리기
			//흰색, 파란색, 빨간색이 몇 줄이 될 수 있는지 경우의 수를 구해서
			//그 경우의 수에 따라 색이 몇번 바뀌는지 체크
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
					//체크한 횟수 중에서 최소값을 구하기
					if(min > cnt) {
						min = cnt;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+min);
		}
	}
}
