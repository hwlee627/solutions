package SWEA_2817_부분수열의합_6w;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	static int N, R;
	static int[] com;
	static int cnt = 0;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] nums = new int[N];
			for(int i = 0; i<N; i++) {
				R = i;
				com = new int[i];
				nums[i] = sc.nextInt();
			}
			List<int[]> list = new ArrayList<int[]>();
			for(int i =1; i<N; i++) {
				R = i;
				com = new int[R];
				combination(nums,0,0,K);
			}
			System.out.println("#"+test_case+" "+cnt);
			cnt = 0;
		}
	}
	public static void combination(int[] nums, int idx, int sidx, int k) {
		
		int sum = 0;
		//기저
		if(sidx == R) {
			for(int i = 0; i<R; i++) {
				sum += com[i];
			}
			if(sum == k) {
				cnt++;
			}
			return;
		}else {
			//재귀
			for(int i = idx; i<=N-R+sidx; i++) {
				com[sidx] = nums[i];
				combination(nums, i+1, sidx+1, k);
			}
		}
		
	}

	
}