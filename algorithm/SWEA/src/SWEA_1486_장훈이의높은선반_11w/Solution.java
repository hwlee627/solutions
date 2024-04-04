package SWEA_1486_장훈이의높은선반_11w;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] arr, tmp;
	static int people, target, M, min;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			
			people = sc.nextInt();
			target = sc.nextInt();
			
			arr = new int[people];
			
			for(int i = 0; i<people; i++) {
				arr[i] = sc.nextInt();
			}
			min = Integer.MAX_VALUE;
			for(int i = 1; i<=people; i++) {
				M = i;
				tmp = new int[M];
				combination(0, 0);
			}
			System.out.println("#"+tc+" "+min);
		}

	}
	private static void combination(int idx, int sidx) {
		if(idx == M) {
			int sum = 0;
//			System.out.println(Arrays.toString(tmp));
			for(int i = 0; i<M; i++) {
				sum += tmp[i];
			}
			if(sum >= target) {
				int ans = sum-target;
				if(min > ans) {
					min = ans;
				}
			}
			return;
		}
		
		for(int i = sidx; i<people; i++) {
			tmp[idx] = arr[i];
			combination(idx+1, i+1);
		}
		
	}

}
