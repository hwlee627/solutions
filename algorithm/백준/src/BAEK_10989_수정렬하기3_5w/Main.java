package BAEK_10989_수정렬하기3_5w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		for(int i = 0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
//		int[] sortedNums = new int[N];
		Arrays.sort(nums);
		
//		for(int i = 0; i<N; i++) {
//			int sameCnt = 0;
//			int bigger = 0;
//			for(int j = 0; j<N; j++) {
//				if(nums[i] == nums[j]) {
//					sameCnt++;
//				}else if(nums[i]<nums[j]) {
//					bigger++;
//				}
//			}
//			if(sameCnt != 1) {
//				for(int k = N-bigger-1; k>=N-bigger-sameCnt; k--) {
//					sortedNums[k] = nums[i];
//				}
//			}else {
//				sortedNums[N-bigger-1] = nums[i];
//			}
//		}
		
//		
//		for(int i = 0; i<N; i++) {
//			System.out.println(nums[i]);
//		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<nums.length; i++) {
			sb.append(nums[i]).append('\n');
		}
		System.out.println(sb);
	}

}
