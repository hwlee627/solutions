package BAEK_14501_퇴사_4w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int max = 0;
			int restSum = 0;
			char maxIdx = ' ';
			int A = sc.nextInt();
			if(max<A) {
				max = A;
				maxIdx = 'A';
			}
			int B = sc.nextInt();
			if(max<B) {
				max = B;
				maxIdx = 'B';
			}
			int C = sc.nextInt();
			if(max<C) {
				max = C;
				maxIdx = 'C';
			}
			
			if(A == B && B == C) {
				break;
			}
			
			if(maxIdx == 'A') {
				restSum = B*B+C*C;
			}else if(maxIdx == 'B'){
				restSum = A*A+C*C;
			}else if(maxIdx == 'C'){
				restSum = B*B+A*A;
			}
			if(max*max == restSum ) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
		}
		
	}
}
