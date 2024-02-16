package BAEK_2581_소수_4w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int cnt = 0;
		int sum = 0;
		int min = 0;
		for(int i = M; i<=N; i++) {
			boolean check = true;
			for(int j = 2; j<=Math.sqrt(i); j++) {
				if(i % j == 0) {
					check = false;
				}
			}
			if(i != 1) {
				if(check) {
					cnt++;
					if(cnt == 1) {
						min = i;
						sum += i;
					}else {
						sum += i;
					}
				}
			}
		}
		if(sum != 0) {
			System.out.println(sum);
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
		
	}
}
