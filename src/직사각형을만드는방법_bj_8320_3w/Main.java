package 직사각형을만드는방법_bj_8320_3w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt = 0;
		int sum = 0;
		int div = 0;
		int result = 0;
		for(int i=1; i<=Math.sqrt(n); i++) {
			div = n/i;
			sum = div-cnt;
			cnt++;
			result += sum;
		}
			
		System.out.println(result);
		
//	
//		for(int i=1; i<n+1; i++)
//			for(int j=1; j<=i; j++)
//				if(i*j <= n)
//					cnt++;
//		System.out.println(cnt);
		
	}
}
