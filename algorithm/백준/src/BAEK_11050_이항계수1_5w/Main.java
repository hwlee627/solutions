package BAEK_11050_이항계수1_5w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		//5 3 2
		int num3 = num1-num2;
		int factorial = 1;
		int result = 1;
		
		if(num3 <= num2) {
			for(int i = num1; i>num2; i--) {
				result *= i;
			}
			for(int i = 1; i<=num3; i++) {
				factorial *= i;
			}
			result = result/factorial;
		}else {
			for(int i = num1; i > num3; i--) {
				result *= i;
			}
			for(int i = 1; i<=num2; i++) {
				factorial *= i;
			}
			result = result/factorial;
		}
		
		System.out.println(result);
	}

}
