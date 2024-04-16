package BAEK_9465_스티커_13w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			if(N == 1) {
				int num = sc.nextInt();
				int num2 = sc.nextInt();
				
				if(num > num2) {
					System.out.println(num);
				}else {
					System.out.println(num2);
				}
			}else {
				int[] up = new int[N];
				int[] down = new int[N];
				
				for(int i = 0; i<N; i++) {
					up[i] = sc.nextInt();
				}
//				System.out.println(Arrays.toString(up));
				for(int i = 0; i<N; i++) {
					down[i] = sc.nextInt();
				}
//				System.out.println(Arrays.toString(down));
				int[][] dp = new int[N][2];
				
				int max = 0;
				dp[0][0] = up[0];
				if(max < dp[0][0]) {
					max = dp[0][0];
				}
				dp[0][1] = down[0];
				if(max < dp[0][1]) {
					max = dp[0][1];
				}
				dp[1][0] = up[1]+dp[0][1];
				if(max < dp[1][0]) {
					max = dp[1][0];
				}
				dp[1][1] = down[1]+dp[0][0];
				if(max < dp[1][1]) {
					max = dp[1][1];
				}
				
				
				int idx = 2;
				
				while(idx<N) {
//					System.out.println("들어오나");
					if(dp[idx-2][1]+up[idx] > dp[idx-1][1]+up[idx]) {
						dp[idx][0] = dp[idx-2][1] + up[idx];
					}else {
						dp[idx][0] = dp[idx-1][1] + up[idx];
					}
					
					if(dp[idx-2][0]+down[idx] > dp[idx-1][0]+down[idx]) {
						dp[idx][1] = dp[idx-2][0] + down[idx];
					}else {
						dp[idx][1] = dp[idx-1][0] + down[idx];
					}
					if(max < dp[idx][0]) {
						max = dp[idx][0];
					}
					if(max < dp[idx][1]) {
						max = dp[idx][1];
					}
					idx++;
				}
//				for(int i = 0; i<N; i++) {
//					System.out.print(dp[i][0]+" ");
//				}
//				System.out.println();
//				for(int i = 0; i<N; i++) {
//					System.out.print(dp[i][1]+" ");
//				}
//				System.out.println();
				System.out.println(max);
			}

		}
	}

}
