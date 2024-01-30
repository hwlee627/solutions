package 최빈수구하기_sw_1204;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.next();
			int max = 0;
			int index = 0;
			int[] score = new int[1000];
			int[] cnt = new int[101];
			for(int i =0; i<1000; i++) {
				score[i] = sc.nextInt();
			}
			
			for(int i =0; i<1000; i++) {
				cnt[score[i]]++;
			}
			
			for(int i =0; i<cnt.length; i++) {
				if(max<cnt[i]) {
					max = cnt[i];
					index = i;
				}
					if(max == cnt[i]) {
						max = cnt[i];
						index = i;
				}
			}
			System.out.println("#"+test_case+" "+index);
			
		}
	}
}
