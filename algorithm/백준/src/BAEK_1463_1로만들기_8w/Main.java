package BAEK_1463_1로만들기_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//1. 3의 배수 :: 3으로 나누기
		//2. 나머지 1 :: -1 후 3으로 나누기
		//3. 나머지 2 :: 짝수 / 나누기 2    홀수 / -1 후 나누기 2
		//4. 16일때. 뭔데 너
		//Dp...
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] dp = new int [1000001];
		
		dp[0] = 0;// 0은 비우고
		dp[1] = 0;// 1
		dp[2] = 1;// 2일 때
		dp[3] = 1;// 3일 때
		
		
		int N = Integer.parseInt(br.readLine());
		int num = 4;
		while(num<=N) {
			int min = Integer.MAX_VALUE;
			if(num % 2 == 0) {
				int cnt = 0;
				if(dp[num/2] != 0) {
					cnt = 1 + dp[num/2];
					if(cnt<min) {
						min = cnt;
					}
				}
			}
			if(num % 3 == 0) {
				int cnt = 0;
				if(dp[num/3] != 0) {
					cnt = 1 + dp[num/3];
					if(cnt<min) {
						min = cnt;
					}
				}
			}
			int cnt = 1 + dp[num-1];
			if(cnt<min) {
				min = cnt;
			}
			dp[num] = min;
			
			num++;
		}
		for(int i = 1; i <=N; i++) {
//			System.out.println(i+"번째 : "+dp[i]);
		}
		System.out.println(dp[N]);
	}

}
