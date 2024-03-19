package BAEK_11727_2xn타일링2_9w;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long sum = 1;
		
		int[] dp = new int[1001];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		if(N>=3) {
			for(int i = 3; i<=1000; i++) {
				if(i % 2 == 0) {
					dp[i] = (dp[i-1]*2 + 1)%10007;
				}else {
					dp[i] = (dp[i-1]*2 - 1)%10007;
				}
				if(i == N) {
					System.out.println(dp[i]);
				}
			}
		}else {
			if(N == 1) {
				System.out.println(1);
			}else {
				System.out.println(3);
			}
		}

		
//		for(int i = 2; i<=N; i++) {
//			if(i % 2 == 0) {
//				 = (sum*2) + 1;
//				if(i == N) {
//					System.out.println(ans);
//				}
//			}else {
//				sum = (sum*2) - 1;
//				if(i == N) {
//					int ans = (int)sum % 10007;
//					System.out.println(ans);
//				}
//			}
//		}

	}

}
