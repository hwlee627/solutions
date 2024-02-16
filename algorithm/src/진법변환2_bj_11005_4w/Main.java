package 진법변환2_bj_11005_4w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		int B = sc.nextInt();
		long left = 0;
		char[] nums = new char[200];
		int cnt = 0;
		for(int i = 1; i < 100; i++) {
			long num = (long)Math.pow(B, i);
			left = number%num;
			number -= left;
			left = left/(num/B);
//			System.out.println("number: "+number+" left: "+left+ " num: "+num);
			if(left >= 10) {
				left += 55;
				nums[i-1] = (char)left;
				cnt++;
			}else {
				nums[i-1] = (char)(left+48);
				cnt++;
			}
			if(number == 0) {
				nums[i] = 'a';
				break;
			}
			
		}
//		System.out.println(Arrays.toString(nums));
		int idx = 0;
		for(int i = 0; i<nums.length; i++) {
			if(nums[i] != 'a' ) {
				idx++;
			}else {
				break;
			}
			//C = 67
			//1 = 49
		}
		for(int i = idx-1; i>= 0; i--) {
			System.out.print(nums[i]);
		}
	}
}