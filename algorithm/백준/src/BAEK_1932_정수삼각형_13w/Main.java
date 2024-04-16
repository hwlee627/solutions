package BAEK_1932_정수삼각형_13w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Number{
		int floor, idx, value;

		public Number(int floor, int idx, int value) {
			this.floor = floor;
			this.idx = idx;
			this.value = value;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int dp[][] = new int[N][N];
		dp[0][0] = sc.nextInt();
		
		List<Number> list = new ArrayList<>();
		int tmp = 0;
		for(int i = 1; i<N; i++) {
			int floor = i;
			list = new ArrayList<>();
			for(int j = 0; j<=i; j++) {
				Number n = new Number(i,j,sc.nextInt());
				list.add(n);
			}
			for(int j = 0; j<i; j++) {
				for(Number n : list) {
					if(n.idx == j || n.idx == j+1) {
						if(dp[n.floor-1][j] + n.value > dp[n.floor][n.idx]) {
							dp[n.floor][n.idx] = dp[n.floor-1][j] + n.value;
						}
					}
				}
			}
		}
		Arrays.sort(dp[N-1]);
		System.out.println(dp[N-1][N-1]);
		
	}

}
