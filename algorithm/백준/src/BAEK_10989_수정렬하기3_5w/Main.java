package BAEK_10989_수정렬하기3_5w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		
		for(int i = 0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		int[] sortedNums = new int[N];
		
		for(int i = 0; i<N; i++) {
			int sameCnt = 0;
			int bigger = 0;
			for(int j = 0; j<N; j++) {
				if(nums[i] == nums[j]) {
					sameCnt++;
				}else if(nums[i]<nums[j]) {
					bigger++;
				}
			}
			if(sameCnt != 1) {
				for(int k = N-bigger-1; k>=N-bigger-sameCnt; k--) {
					sortedNums[k] = nums[i];
				}
			}else {
				sortedNums[N-bigger-1] = nums[i];
			}
		}
		
		
		System.out.println(Arrays.toString(sortedNums));
		
	}

}
