package BAEK_2609_최대공약수와최소공배수_5w;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean[] prime = new boolean[10001];
		//소수 = false 소수 아니면 true
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i < 10000; i++) {
			if(!prime[i]) {
				for(int j = i*i; j<=10000; j+=i) {
					prime[j] = true;
				}
			}
		}
		List<Integer> primeList = new ArrayList<Integer>();
		
		for(int i = 0; i < prime.length; i++) {
			if(!prime[i]) {
				primeList.add(i);
			}
		}
		
		Scanner sc= new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int min = 1;
		int max = 0;
		int N = num1;
		int M = num2;
		while(true) {
			boolean check = false;
			for(int primeNum : primeList) {
				if(N % primeNum == 0 && M % primeNum == 0 ) {
					min = min * primeNum;
					N = N/primeNum;
					M = M/primeNum;
					check = true;
					break;
				}
			}
			if(!check) {
				max = num1*num2/min;
				System.out.println(min);
				System.out.println(max);
				break;
			}
		}
		
	}

}
