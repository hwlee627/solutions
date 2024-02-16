package 분수찾기_bj_1193_4w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int sum = 0;
		int depth = 0;
		int mom = 0;
		int son = 0;
		for(int i = 1; i<10000000; i++) {
			sum += i;
			if(X <= sum) {
				if(i % 2 == 0) {
					depth = sum - X;
					mom = i-depth;
					son = 1+depth;
					break;
				}else {
					depth = sum - X;
					mom = 1+depth;
					son = i-depth;
					break;
				}
				
			}
			
		}
		System.out.println(mom+"/"+son);

	}

}
