package BAEK_16953_A에서B_12w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		boolean check = false;
		int cnt = 0;
		while(A<B) {
			if(B%10 == 1) {
				B = B/10;
				cnt++;
//				System.out.println(B);
			}else if(B%10 == 2) {
				B = B/2;
				cnt++;
//				System.out.println(B);
			}else if(B%2 == 0) {
				B = B/2;
				cnt++;
//				System.out.println(B);
			}else if(B%2 == 1) {
//				System.out.println(B);
				break;
				
			}
			
			if(A == B) {
				check = true;
				break;
			}
		}

		if(check) {
			System.out.println(cnt+1);
		}else {
			System.out.println(-1);
		}
		

	}

}
