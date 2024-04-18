package BAEK_2096_내려가기_13w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[][] dpMax = new int[T][3];
		int[][] dpMin = new int[T][3];
		
		for(int i = 0; i<T; i++) {
			Arrays.fill(dpMin[i], Integer.MAX_VALUE);
		}
		
		int[][] nums = new int[T][3];
		
		
		for(int r = 0; r<T; r++) {
			for(int c = 0; c<3; c++) {
				nums[r][c] = sc.nextInt();
				if(r == 0) {
					dpMax[r][c] = nums[r][c];
					dpMin[r][c] = nums[r][c];
				}
			}
		}
		
		//최대값 구하기
		
		for(int r = 0; r<T-1; r++) {
			for(int c = 0; c<3; c++) {
				if(c == 0) {
					if(dpMax[r+1][0] < dpMax[r][0]+nums[r+1][0]) {
						dpMax[r+1][0] = dpMax[r][0]+nums[r+1][0];
					}
					if(dpMax[r+1][1] < dpMax[r][0] + nums[r+1][1]) {
						dpMax[r+1][1] = dpMax[r][0] + nums[r+1][1];
					}
				}else if(c == 1) {
					if(dpMax[r+1][1] < dpMax[r][1]+nums[r+1][1]) {
						dpMax[r+1][1] = dpMax[r][1]+nums[r+1][1];
					}
					if(dpMax[r+1][0] < dpMax[r][1] + nums[r+1][0]) {
						dpMax[r+1][0] = dpMax[r][1] + nums[r+1][0];
					}
					if(dpMax[r+1][2] < dpMax[r][1]+nums[r+1][2]) {
						dpMax[r+1][2] = dpMax[r][1]+nums[r+1][2];
					}
				}else if(c == 2) {
					if(dpMax[r+1][2] < dpMax[r][2]+nums[r+1][2]) {
						dpMax[r+1][2] = dpMax[r][2]+nums[r+1][2];
					}
					if(dpMax[r+1][1] < dpMax[r][2] + nums[r+1][1]) {
						dpMax[r+1][1] = dpMax[r][2] + nums[r+1][1];
					}
				}
			}
		}
		
		//최솟값 구하기
		
		for(int r = 0; r<T-1; r++) {
			for(int c = 0; c<3; c++) {
				if(c == 0) {
					if(dpMin[r+1][0] > dpMin[r][0] + nums[r+1][0]) {
						dpMin[r+1][0] = dpMin[r][0] + nums[r+1][0];
					}
					if(dpMin[r+1][1] > dpMin[r][0] + nums[r+1][1]) {
						dpMin[r+1][1] = dpMin[r][0] + nums[r+1][1];
					}
					
				}else if(c == 1) {
					if(dpMin[r+1][0] > dpMin[r][1] + nums[r+1][0]) {
						dpMin[r+1][0] = dpMin[r][1] + nums[r+1][0];
					}
					if(dpMin[r+1][1] > dpMin[r][1] + nums[r+1][1]) {
						dpMin[r+1][1] = dpMin[r][1] + nums[r+1][1];
					}
					if(dpMin[r+1][2] > dpMin[r][1] + nums[r+1][2]) {
						dpMin[r+1][2] = dpMin[r][1] + nums[r+1][2];
					}
					
				}else if(c == 2) {
					if(dpMin[r+1][2] > dpMin[r][2] + nums[r+1][2]) {
						dpMin[r+1][2] = dpMin[r][2] + nums[r+1][2];
					}
					if(dpMin[r+1][1] > dpMin[r][2] + nums[r+1][1]) {
						dpMin[r+1][1] = dpMin[r][2] + nums[r+1][1];
					}
				}
			}
		}
		
		Arrays.sort(dpMax[T-1]);
		Arrays.sort(dpMin[T-1]);
		
		int max = dpMax[T-1][2];
		int min = dpMin[T-1][0];
		
		System.out.println(max +" "+min);
	}

}
