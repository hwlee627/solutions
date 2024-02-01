package 파리퇴치_sw_2001;

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
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] flies = new int [N][N];
			//탐색용 배열 선언
			//MxM칸을 모두 탐색해야 하기 때문에 배열 크기도 MxM으로 지정
			int[] mr = new int[M*M];
			int[] mc = new int[M*M];
			
			int cnt = 0;
			int num = 0;
			int sum = 0;
			int max = 0;
			
			//MxM 칸 탐색용 배열 생성
			//목표 = M이 3이라면,
			//{0,0,0,1,1,1,2,2,2}가 되도록
			//같은 숫자 반복은 M회, 횟수 끝나면 숫자가 1씩 상승
			for(int i = 0; i<M*M; i++) {
				mr[i] = num;
				cnt++;
				if(cnt == M) {
					num++;
					cnt=0;
				}
				
			}
			//목표 M=3이라면,
			//{0,1,2,0,1,2,0,1,2}가 되도록
			//index번호인 i를 M으로 나눈 나머지의 반복
			for(int i = 0; i<M*M; i++) {
				mc[i] = i%M;
			}
			//결과

			//배열생성
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					flies[r][c] = sc.nextInt();
				}
			}
			//만든 배열과 탐색 배열로 탐색하여 탐색한 칸들의 총 합을 구하고
			//위에서 선언한 max 변수에 넣어 최대값을 구함
			
			for(int r =0; r<=N-M; r++) {
				for(int c = 0; c<=N-M; c++) {
					sum = 0;
					for(int d = 0; d<M*M; d++) {
						int nr = r+mr[d];
						int nc = c+mc[d];
						//탐색 후 좌표값들을 sum변수로 합쳐줌
						sum += flies[nr][nc];
						
					}
					//max라는 변수에 합한 결과값들을 넣을 때
					//sum이 더 크면 max를 갱신하게 하여
					//sum으로 나온 값들 중 가장 큰 값이 최종적으로 남도록 함
					if(sum > max) {
						max = sum;
					}
				}
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
}