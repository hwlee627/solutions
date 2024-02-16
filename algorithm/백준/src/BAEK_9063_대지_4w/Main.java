package BAEK_9063_대지_4w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int minX = 10001;
		int minY = 10001;
		int maxX = -10001;
		int maxY = -10001;
		if(N != 1) {
			for(int i = 1; i <= N; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				
				if(X > maxX) {
					maxX = X;
				}
				if(Y > maxY) {
					maxY = Y;
				}
				if(minX > X) {
					minX = X;
				}
				if(minY > Y) {
					minY= Y;
				}
			}
			int width = (maxX-minX) * (maxY-minY);
			System.out.println(width);
		}else {
			System.out.println(0);
		}


	}

}
