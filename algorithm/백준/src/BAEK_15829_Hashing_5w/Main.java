package BAEK_15829_Hashing_5w;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextLong();
		long sum = 0;
		
		String str = sc.next();
		int length = str.length();
		
		for(int i = 0; i<length; i++) {
			int num = str.charAt(i)-96;
			sum += (long)num*(long)Math.pow(31, i);
			if(sum >= 1234567891) {
				sum = sum%1234567891;
			}
		}
		if(sum <= 1234567891) {
			System.out.println(sum);
		}
//		else {
//			while(true) {
//				sum = sum%1234567891;
//				if(sum <= 1234567891) {
//					break;
//				}
//			}
//			System.out.println(sum);
//		}
		
	}
}
