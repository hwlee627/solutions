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
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] flies = new int [N][N];
			int[] mr = new int[M*M];
			int[] mc = new int[M*M];
			int cnt = 0;
			int num = 0;
			int sum = 0;
			int max = 0;
			//MxM 칸 탐색용 배열 생성
			
			for(int i = 0; i<M*M; i++) {
				mr[i] = num;
				cnt++;
				if(cnt == M) {
					num++;
					cnt=0;
				}
				
			}
			for(int i = 0; i<M*M; i++) {
				mc[i] = i%M;
			}
			
			
//			System.out.println(Arrays.toString(mr));
//			System.out.println(Arrays.toString(mc));
			//배열생성
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					flies[r][c] = sc.nextInt();
				}
			}
			
			//출력
//			for(int r = 0; r<N; r++) {
//				for(int c = 0; c<N; c++) {
//					System.out.printf("%3d", flies[r][c]);
//				}
//				System.out.println();
//			}
			
			for(int r =0; r<=N-M; r++) {
				for(int c = 0; c<=N-M; c++) {
					sum = 0;
					for(int d = 0; d<M*M; d++) {
						int nr = r+mr[d];
						int nc = c+mc[d];
						sum += flies[nr][nc];
						
					}
					if(sum > max) {
						max = sum;
					}
				}
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
}