package 농작물수확하기_sw_2805;

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
			
			//N은 늘 홀수
			int[][] farmArr = new int [N][N];
			for(int i = 0; i<N; i++) {
				String[] nums = String.valueOf(sc.next()).split("");
				
				//행렬 생성
				
					for(int c = 0; c<N; c++) {
						farmArr[i][c] = Integer.parseInt(nums[c]); 
					}
//					System.out.println(Arrays.toString(nums));
			}
			
			
//			for(int r = 0; r<N; r++) {
//				for(int c = 0; c<N; c++) {
//					System.out.printf("%3d", farmArr[r][c]);
//				}
//				System.out.println();
//			}
			
			//농장의 한 줄을 다 채울 때의 r의 좌표를 구하고 그 좌표를 기준으로 위 아래 로직을 짜자
			int halfNum = N/2; //인덱스번호 기준이므로
			//농작물 수확량의 합을 담을 정수 선언
			int sum = 0;
			//순회
			//1. halfNum보다 위
			//2. r == halfnum
			//3. halfNum보다 아래
			if(N == 1) {
				sum = farmArr[0][0];
			}else {
				for(int r = 0; r<N; r++) {
					if(r == halfNum) {
						for(int c = 0; c<N; c++) {
							sum += farmArr[r][c];
//							System.out.println("r: "+r+" c: "+c);
//							System.out.println(sum);
						}
					}else if(r < halfNum) {
						for(int c = halfNum-r; c<=halfNum+r; c++) {
							sum += farmArr[r][c];
//							System.out.println("r: "+r+" c: "+c);
//							System.out.println(sum);
						}
					}else if(r > halfNum) {
						//끝 좌표 (r,c)는 항상 일정 -> (halfNum + N - 1);
						for(int c = r-halfNum; c<=(halfNum+N-1)-r; c++) {
							sum += farmArr[r][c];
//							System.out.println("r: "+r+" c: "+c);
//							System.out.println(sum);
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+ sum);
			
		}
	}
}