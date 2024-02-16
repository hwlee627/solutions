package 세탁소사장동혁_bj_2720_4w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T  = sc.nextInt();
		
		for(int test = 1; test<=T; test++) {
			int price = sc.nextInt();
			
			//쿼터 25
			//다임 10
			//니켈 5
			//페니 1
			
			int Q = 25;
			int D = 10;
			int N = 5;
			int P = 1;
			int[] coinCnt = new int[4];
			int cnt = 0;
			int idx = 0;
			
			cnt = price / Q;
			price = price - cnt*Q;
			coinCnt[idx] = cnt;
			idx++;
			cnt = 0;
			
			cnt = price / D;
			price = price - cnt*D;
			coinCnt[idx] = cnt;
			idx++;
			cnt = 0;
			
			cnt = price / N;
			price = price - cnt*N;
			coinCnt[idx] = cnt;
			idx++;
			cnt = 0;
			
			cnt = price;
			coinCnt[idx] = cnt;
			
			for(int i = 0; i<4; i++) {
				System.out.printf(coinCnt[i]+" ");
			}
			System.out.println();
		}
			
		

	}

}
