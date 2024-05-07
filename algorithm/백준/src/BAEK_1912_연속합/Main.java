package BAEK_1912_연속합;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int max = 0;
		int sum = 0;
		int tmp = 0;
		for(int i = 0; i<N; i++) {
			if(i==0) {
				tmp = sc.nextInt();
			}else {
				int num = sc.nextInt();
				sum = tmp + num;
				if(max < sum) {
					max = sum;
				}
				sum = sum - tmp;
				tmp = num;
			}
		}
		System.out.println(max);
	}

}
