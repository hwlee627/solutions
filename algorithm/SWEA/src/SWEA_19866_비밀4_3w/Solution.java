package SWEA_19866_비밀4_3w;

import java.util.Arrays;
import java.io.FileInputStream;
import java.util.Scanner;

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
			//출발지에는 항상 충전기
			//횟수는 세지 않음
			//도착할 수 없는 경우 0
			//도착할 수 있으면 충전 최소 횟수 출력
			
			//한 번 충전에 갈 수 있는 정류장 수
			int K = sc.nextInt();
			
			//종점이 N번 정류장임
			int N = sc.nextInt();
			
			//충전기는 M개 정류장에 설치되어 있음
			int M = sc.nextInt();
			
			//충전기가 설치된 정류장 배열
			int[] recharger = new int [M];
			int[] busStop = new int[N+1];
			
			
			for(int i = 0; i<M; i++) {
				recharger[i] = sc.nextInt();
			}
			for(int i = 0; i<M; i++) {
				busStop[recharger[i]]++;
			}
//			System.out.println(Arrays.toString(recharger));
//			System.out.println(Arrays.toString(busStop));
			//처음엔 충전기가 있음
			int goAble = K;
			int chargeCnt = 0;
			int meetRecharger = 0;
			
			//처음 충전기를 건너뛰는지 판단
			for(int i =1; i < busStop.length; i++) {
				if(busStop[i] == 1) {
					meetRecharger++;
				}
				
				if(i % K == 0) {
					if(meetRecharger >= 2) {
						meetRecharger =0;
						chargeCnt++;
					}else if(meetRecharger == 1) {
						chargeCnt++;
					}else if(meetRecharger == 0) {
						chargeCnt = 0;
						break;
					}
				}
				
			}
			
			System.out.println("#"+test_case+" "+chargeCnt);
		}
	}
}
