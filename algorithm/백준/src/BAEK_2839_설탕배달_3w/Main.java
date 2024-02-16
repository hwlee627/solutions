package BAEK_2839_설탕배달_3w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int weight = sc.nextInt();
		int multiple5 = 5;
		int cnt = 0;
		while(weight - multiple5 >=0) {
			if((weight - multiple5) % 3 == 0) {
				cnt = (weight - multiple5)/3 + (multiple5)/5;
				(multiple5)+=5;
			}
			(multiple5)+=5;
		}
		
		if(cnt == 0) {
			if(weight%3 == 0) {
				cnt = weight/3;
			}else {
				cnt = -1;
			}
		}
		System.out.println(cnt);

	}

}
