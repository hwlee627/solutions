package BAEK_2292_벌집_4w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum = 1;
		int ans = 0;
		for(int i = 1; i<Integer.MAX_VALUE; i++) {
			if(N<=sum) {
				ans = i;
				break;
			}
			sum += i*6;
			
		}
		System.out.println(ans);

	}

}
