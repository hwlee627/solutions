package BAEK_6064_카잉달력_11w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt() -1;
			int y = sc.nextInt() -1;
			boolean find = false;
			for(int i = x; i<(M*N); i+=M) {
				if(i%N == y) {
					System.out.println(i+1);
					find = true;
					break;
				}
			}

			
			if(!find) {
				System.out.println(-1);
			}
		}

	}

}
