package BAEK_1676_팩토리얼0의개수_5w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		//5당 0이 한개씩 늘어남
		// 2 5
//		int N = sc.nextInt();
//		int zeroCnt = 0;
//		if(N%10 != 0) {
//			if(N%10 >= 5) {
//				zeroCnt ++;
//			}
//		}
//		if(N>=10) {
//			zeroCnt += (N/10)*2;
//		}
//		
//		
//		System.out.println(zeroCnt);
		int N = sc.nextInt();
		int zeroCnt = 0;
		zeroCnt += (N/5);
		zeroCnt += (N/25);
		
		if(N>100) {
			zeroCnt += N/100;
		}
		
		
		System.out.println(zeroCnt);
		
	}
	
	

}
