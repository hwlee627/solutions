package 퇴사_bj_14501_4w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		int B = sc.nextInt();
		int left = 0;
		char[] nums = new char[100];
		
		for(int i = 1; i < 20; i++) {
			int num = (int)Math.pow(B, i);
			left = number%num;
			number -= left;
			left = left/(num/B);
			if(left >= 10) {
				left += 55;
				nums[i-1] = (char)left;
			}else {
				System.out.println(left);
			}
			
			
		}
		System.out.println(Arrays.toString(nums));
	}
}
