package baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		int times = sc.nextInt();
		int[] bucket = new int[length];
		for(int i = 0; i < length; i++) {
			bucket[i] = i+1;
		}
		
		for(int i = 1; i<=times; i++) {
			int change1 = sc.nextInt()-1;
			int change2 = sc.nextInt()-1;
			int tmp = 0;
			tmp = bucket[change1];
			bucket[change1] = bucket[change2];
			bucket[change2] = tmp;
		}
		for(int i = 0; i<length; i++) {
			System.out.print(bucket[i]+" ");
		}
	}
}
