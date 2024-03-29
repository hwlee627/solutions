package BAEK_14501_퇴사_4w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		boolean[] prime = new boolean[10001];
		//소수 = false 소수 아니면 true
		prime[0] = true;
		prime[1] = false;
		
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
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int divNum = 1;
		int mulNum = 0;
		boolean run = true;
		if(num1 == num2) {
			divNum = num1;
			mulNum = num1;
		}else {
			while(run) {
				for(int primeNum : primeList) {
					if(num1 % primeNum == 0 && num2 % primeNum == 0) {
						divNum *= primeNum;
						
					}else {
						run = false;
					}
					
				}
			}
			mulNum = (num1*num2)/divNum;
		}
		
		
		
		System.out.println(divNum);
		System.out.println(mulNum);
	}
}
