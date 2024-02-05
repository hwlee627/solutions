package OX퀴즈_bj_8958_3w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 1; test_case<=T; test_case++) {
			
			String OX = sc.nextLine();
			
			String[] oxArr = String.valueOf(OX).split("");
			
			int cnt = 0;
			int sum = 0;
			for(int i =0; i<oxArr.length; i++) {
				if(oxArr[i].equals("O")) {
					++cnt;
					sum += cnt;
				}else {
					cnt = 0;
				}
			}
			System.out.println(sum);
		}

	}

}
