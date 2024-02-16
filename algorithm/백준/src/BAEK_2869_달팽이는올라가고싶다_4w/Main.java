package BAEK_2869_달팽이는올라가고싶다_4w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
//		while(true) {
//			
//			move += A;
//			if(move>=V) {
//				break;
//			}
//			move -= B;
//			days++;
//		}
		
		int meter = V-B;
		int movePerDay = A-B;
		int days = (int)Math.ceil(meter/(double)movePerDay);
		System.out.println(days);

	}

}
