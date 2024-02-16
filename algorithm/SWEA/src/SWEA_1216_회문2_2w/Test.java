package SWEA_1216_회문2_2w;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(str);
		
		
		char[] a = {'a', 'b', 'c'};
		char[] b = {'a', 'b', 'd'};
		String aa = "";
		String bb = "";
		
		for(int i = 0; i<a.length; i++) {
			aa += a[i];
			bb += b[i];
		}
		System.out.println(aa + " " + bb);
		System.out.println(aa.length());
	}

}
