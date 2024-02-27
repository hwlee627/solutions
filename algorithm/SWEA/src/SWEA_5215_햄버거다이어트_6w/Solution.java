package SWEA_5215_햄버거다이어트_6w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
static int limit;
static int N, R, K, tasteSum, tasteMax;
static int[] taste, cal, comTaste, comCal;
static List<Integer> tasteSumList = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc= 1; tc<= T; tc++) {
			N = sc.nextInt();
			limit = sc.nextInt();
			
			cal = new int[N];
			taste = new int[N];
			tasteSum = 0;
			tasteMax = 0;
			int calIdx = 0;
			int tasteIdx = 0;
			for(int i = 0; i<N*2; i++) {
				if(i % 2 == 0) {
					taste[tasteIdx] = sc.nextInt();
					tasteIdx++;
				}else {
					cal[calIdx] = sc.nextInt();
					calIdx++;
				}
			}
			
			
			for(int i = 1; i<=N; i++) {
				R = i;
				comCal = new int[R];
				comTaste = new int[R];
				getMaxTaste(0, 0);
			}
			System.out.println("#"+tc+" "+tasteMax);
			
		}

	}
	public static void getMaxTaste(int idx, int sidx) {
		int calSum = 0;
		
		//기저
		if(sidx >= R) {
			tasteSum = 0;
			for(int i = 0; i<comCal.length; i++) {
				calSum += comCal[i];
				tasteSum += comTaste[i];
				if(calSum <= limit) {
					if(tasteMax < tasteSum) {
						tasteMax = tasteSum;
					}
				}
			}
			return;
		}
		
		//재귀
		
		for(int i = idx; i<=N-R+sidx; i++) {
			comTaste[sidx] = taste[i];
			comCal[sidx] = cal[i];
			getMaxTaste(i+1, sidx+1);
		}
	}

}
