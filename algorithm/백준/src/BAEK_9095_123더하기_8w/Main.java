package BAEK_9095_123더하기_8w;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] count = new int[10];
		
		count[0] = 1;
		count[1] = 2;
		count[2] = 4;
		for(int i = 3; i<10; i++) {
			count[i] = count[i-3] + count[i-2] + count[i-1]; 
		}
		for(int i = 0 ; i<N; i++) {
			System.out.println(count[sc.nextInt()-1]);
		}
	}	

}
