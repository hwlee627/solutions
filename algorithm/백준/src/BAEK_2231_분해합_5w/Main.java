package BAEK_2231_분해합_5w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		boolean check = true;
		for(int i = 1; i<=num; i++) {
			int sum = 0;
			String str = Integer.toString(i);
			for(int j = 0; j<str.length(); j++) {
				sum += str.charAt(j)-48;
			}
			if(num == i+sum) {
				System.out.println(i);
				check = true;
				break;
			}else {
				check = false;
			}
		}
		if(!check) {
			System.out.println(0);
		}
		
		

	}

}
