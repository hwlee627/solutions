package 자료구조;

import java.util.Arrays;

public class Combination {
	private static int n, m;
	private static int[] arr, nums;
	public static void main(String[] args) {
		
		n = 4;
		nums = new int[n];
		for(int i = 0; i<n; i++) {
			nums[i] = i+1;
		}
		
		System.out.println(Arrays.toString(nums));
		
		for(int i = 1; i<=n; i++) {
			m = i;
			arr = new int[m];
			Combination(0, 0);
		}

	}
	private static void Combination(int idx, int sidx) {
		if(idx == m) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i = sidx; i<n ;i++) {
			arr[idx] = nums[i];
			Combination(idx+1, i+1);  //i+1 -> 중복 허용 X i -> 중복 허용
		}
		
	}

}
