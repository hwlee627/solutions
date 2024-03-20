package BAEK_19532_수학은비대면강의입니다_9w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int x = -999; x<=999; x++) {
			for(int y = -999; y<=999; y++) {
				if(a*x + b*y == c && d*x + e*y == f) {
					sb.append(x+" "+y);
				}
			}
		}
		System.out.println(sb);

	}

}
