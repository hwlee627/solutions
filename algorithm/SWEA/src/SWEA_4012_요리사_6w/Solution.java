package SWEA_4012_요리사_6w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int[] com;
	static int[] com2;
	static int[] intArr;
	static int[] intArr2;
	static List<Integer> sumList; 
	static List<Integer> sumList2;
	static int[][] taste;
	static int N, R, N2, R2;
	static List<int[]> list = new ArrayList<int[]>();
	static List<int[]> list2 = new ArrayList<int[]>();
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			list = new ArrayList<int[]>();
			list2 = new ArrayList<int[]>();
			
			N = sc.nextInt();
			R = N/2;
			taste = new int[N][N];
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					taste[r][c] = sc.nextInt();
				}
			}
			
			
			int[] arr = new int[N];
			
			for(int i = 1; i<=N; i++) {
				arr[i-1] = i;
			}
			com = new int[R];
			com2 = new int[R];
			sumList = new ArrayList<Integer>();
			sumList2 = new ArrayList<Integer>();
			combination(arr,0,0);
			
			int sumIdx = 0;
			int[] sumArr = new int[sumList.size()];
			int[] sumArr2 = new int[sumList2.size()];
			for(int sum : sumList) {
				sumArr[sumIdx]= sum;
				sumIdx++;
			
			}
			sumIdx = 0;
			for(int sum : sumList2) {
				sumArr2[sumIdx]= sum;
				sumIdx++;
			}
			int combi = comCnt(R);
			for(int i = 0 ; i<sumArr.length; i+=combi) {
				int sum = 0;
				int sum2 = 0;
				for(int j = i+combi-1; j>=i; j--) {
					sum += sumArr[j];
					sum2 += sumArr2[j];
				}
				if(min> Math.abs(sum-sum2)) {
					min = Math.abs(sum-sum2);
				}
			}
			System.out.println("#"+tc+" "+min);
			min=Integer.MAX_VALUE;
			
		}
	}
	public static void combination(int[] arr, int idx, int sidx) {
		boolean[] check = new boolean[arr.length];
		// 기저
		int a = 0;
		if(sidx >= R) {
			for(int i = 0; i<R; i++) {
				check[com[i]-1] = true;
			}
			for(int i = 0; i<N; i++) {
				if(!check[i]) {
					com2[a] = arr[i];
					a++;
				}
			}

			R2=2;
			N2=com.length;
			intArr = new int[R2];
			intArr2 = new int[R2];
			combination2(com, 0, 0);
			combination3(com2, 0, 0);
			return;
		}
		
		// 재귀
		for(int i = idx; i<=N-R+sidx; i++) {
			com[sidx] = arr[i];
			combination(arr, i+1, sidx+1);
		}
		
		
	}
	
	public static void combination2(int[] arr, int idx, int sidx) {
		
		//기저
		if(sidx >= R2) {
			int sum = 0;

			sum = taste[intArr[0]-1][intArr[1]-1]+taste[intArr[1]-1][intArr[0]-1];

			sumList.add(sum);
			return;
		}
		
		//재귀
		for(int i = idx; i<=N2-R2+sidx; i++) {
			intArr[sidx]=arr[i];
			combination2(arr,i+1,sidx+1);
		}
	}
	public static void combination3(int[] arr, int idx, int sidx) {
		
		//기저
		if(sidx >= R2) {
			int sum2 = 0;

			sum2 = taste[intArr2[0]-1][intArr2[1]-1]+taste[intArr2[1]-1][intArr2[0]-1];

			sumList2.add(sum2);
			return;
		}
		//재귀
		for(int i = idx; i<=N2-R2+sidx; i++) {
			intArr2[sidx]=arr[i];
			combination3(arr, i+1, sidx+1);
		}
	}
	public static int comCnt(int a) {
		return a*(a-1)/2;
	}

}
