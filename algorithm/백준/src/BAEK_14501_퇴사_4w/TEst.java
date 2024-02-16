package BAEK_14501_퇴사_4w;

import java.util.Scanner;

public class TEst {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//65 ~ 90
		String str = sc.next();
		int num = sc.nextInt();
		
		int[] nums = new int[str.length()];
		
		for(int i = 0; i<str.length(); i++) {
			int charTonum = str.charAt(i);
			if(charTonum >=65) {
				charTonum -= 55;
			}else {
				charTonum -= 48;
			}
			nums[i] = charTonum;
		
		}
		int sum = 0;
		for(int i = 0; i<str.length(); i++) {
			sum += nums[i]*Math.pow(num, str.length()-1-i);
		}
		System.out.println(sum);
		
	}
}
