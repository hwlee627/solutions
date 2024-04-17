package BAEK_1026_보물_13w;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<Integer> listNum1 = new ArrayList<Integer>();
		List<Integer> listNum2 = new ArrayList<Integer>();
		for(int i = 0; i<N; i++) {
			listNum1.add(sc.nextInt());
		}
		for(int i = 0; i<N; i++) {
			listNum2.add(sc.nextInt());
		}
		
		Collections.sort(listNum1);
		Collections.sort(listNum2);
		Collections.reverse(listNum2);
		
		int sum = 0;
		for(int i = 0; i<N; i++) {
			int A = listNum1.get(i);
			int B = listNum2.get(i);
			
			sum += A*B;
		}
		System.out.println(sum);
	}

}
