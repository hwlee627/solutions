package BAEK_2217_로프;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] count = new int [10001];
		
		for(int i = 0; i<N; i++) {
			count[sc.nextInt()]++;
		}
		int max = 0;
		for(int i = 0; i<=10000; i++) {
			if(count[i] != 0) {
				int sum = N * i;
				if(max < sum) {
					max = sum;
				}
				N = N - count[i];
			}
		}
		System.out.println(max);

	}

}
