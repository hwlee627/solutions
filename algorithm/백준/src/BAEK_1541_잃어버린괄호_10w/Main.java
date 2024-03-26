package BAEK_1541_잃어버린괄호_10w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		char[] a = str.toCharArray();
		String num = "";

		int cnt = 0;
		for(int i = 0; i<a.length; i++) {
			if(a[i] <= '9' && a[i] >= '0') {
			}else {
				cnt++;
			}
		}
		char[] marks = new char[cnt];
		int[] nums = new int[cnt+1];
		
		int numIdx = 0;
		int markIdx = 0;
		for(int i = 0; i<a.length; i++) {
			if(a[i]<='9' && a[i]>='0') {
				num = num+a[i];
			}else {
				nums[numIdx] = Integer.parseInt(num);
				marks[markIdx] = a[i];
				num = "";
				numIdx++;
				markIdx++;
			}
			if(i == a.length-1) {
				nums[numIdx] = Integer.parseInt(num);
			}
		}
//		System.out.println(Arrays.toString(nums));
//		System.out.println(Arrays.toString(marks));
		boolean[] usedNum = new boolean[nums.length];
		boolean[] usedMark = new boolean[marks.length];
		
		boolean minus = false;
		for(int i = 0; i<marks.length; i++) {
			if(minus) {
				if(marks[i] == '-') {
					minus = false;
				}else {
					int sum = 0;
					if(nums[i] < 0) {
						sum = nums[i] + -nums[i+1];
						nums[i] = 0;
						nums[i+1] = sum;
					}else {
						sum = -nums[i] + -nums[i+1];
						nums[i] = 0;
						nums[i+1] = sum;
					}
				}
			}
			if(marks[i] == '-') {
				minus = true;
			}
		}
//		System.out.println(Arrays.toString(nums));
//		System.out.println(Arrays.toString(marks));
		numIdx = 1;
		markIdx = 0;
		int result = nums[0];
		while(true) {
			if(numIdx == nums.length) {
				break;
			}
			if(marks[markIdx] == '-') {
				result -= nums[numIdx];
				numIdx++;
				markIdx++;
			}else {
				result += nums[numIdx];
				numIdx++;
				markIdx++;
			}
		}
		System.out.println(result);
		
	}

}
