package SWEA_1970_쉬운거스름돈_11w;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			
			//50000 10000 5000 1000 500 100 50 10
			int[] coin = new int[8];
			
			int change = sc.nextInt();
			
			int cnt = 0;
			
			cnt = change/50000;
			coin[0] = cnt;
			change = change-(cnt*50000);
			
			cnt = change/10000;
			coin[1] = cnt;
			change = change-(cnt*10000);
			
			cnt = change/5000;
			coin[2] = cnt;
			change = change-(cnt*5000);
			
			cnt = change/1000;
			coin[3] = cnt;
			change = change-(cnt*1000);
			
			cnt = change/500;
			coin[4] = cnt;
			change = change-(cnt*500);
			
			cnt = change/100;
			coin[5] = cnt;
			change = change-(cnt*100);
			
			cnt = change/50;
			coin[6] = cnt;
			change = change-(cnt*50);
			
			cnt = change/10;
			coin[7] = cnt;
			change = change-(cnt*10);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc+" \n");
			for(int n : coin) {
				sb.append(n+" ");
			}
			System.out.println(sb);
		}

	}

}
