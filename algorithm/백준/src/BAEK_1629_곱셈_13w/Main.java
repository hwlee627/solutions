package BAEK_1629_곱셈_13w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextInt();
		long M = sc.nextInt();
		long K = sc.nextInt();
		
		for(int i = 1; i<=10; i++) {
			System.out.println(Math.pow(N, i)%K);
		}
		
		
		
	}

}
