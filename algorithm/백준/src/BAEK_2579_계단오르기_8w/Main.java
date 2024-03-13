package BAEK_2579_계단오르기_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[]stairs = new int[N+1];
		
		stairs[0] = 0;
		for(int i = 1; i<=N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		int[][] dp = new int[301][2];
		
		if(N >= 2) {
			dp[0][0] = 0;
			dp[1][1] = stairs[1];
			dp[2][0] = stairs[2]; //두칸으로 올라온 것
			dp[2][1] = stairs[1]+stairs[2];
		}else {
			System.out.println(stairs[1]);
		}

		
		
		int idx = 3;
		while(idx <= N) {
			
			int max = 0;
			

				int score1 = dp[idx-1][0] + stairs[idx];// -> dp[idx][1];
				
				int score2 = dp[idx-2][1] + stairs[idx];// -> dp[idx][0];
				int score3 = dp[idx-2][0] + stairs[idx];
				
				if(score2 >= score3) {
					dp[idx][0] = score2;
				}else {
					dp[idx][0] = score3;
				}
				
				dp[idx][1] = score1;
			
			idx++;
		}
		if(N>=2) {
			if(dp[N][0] >= dp[N][1]) {
				System.out.println(dp[N][0]);
			}else {
				System.out.println(dp[N][1]);
			}
		}

		
		
	}

}
