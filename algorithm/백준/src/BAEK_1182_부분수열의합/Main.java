package BAEK_1182_부분수열의합;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, R, tar,cnt;
	static int[] tmp, nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		tar = sc.nextInt();
		
		
		nums = new int[N];
		for(int i = 0; i<N; i++) {
			nums[i] = sc.nextInt();
			
		}
		cnt = 0;
		for(int i = 1; i<=5; i++) {
			R = i;
			tmp = new int[R];
			combination(0,0);
		}
		System.out.println(cnt);
		
	}
	private static void combination(int idx, int sidx) {
		if(idx == R) {
			int sum = 0;
//			System.out.println(Arrays.toString(tmp));
			for(int i = 0; i<R; i++) {
				sum += tmp[i];
			}
			if(sum == tar) {
				cnt++;
			}
			return;
		}
		for(int i = sidx; i<N; i++) {
			tmp[idx] = nums[i];
			combination(idx+1, i+1); //중복허용 안하니까
		}
		
	}

}
