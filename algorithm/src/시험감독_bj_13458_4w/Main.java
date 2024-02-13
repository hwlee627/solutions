package 시험감독_bj_13458_4w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testClass = sc.nextInt();
		
		int[] studentCnt = new int[testClass];
		for(int i = 0; i<testClass; i++) {
			studentCnt[i] = sc.nextInt();
		}
		int mainT = sc.nextInt();
		int subT = sc.nextInt();
		long Tcnt = 0;
		long sum = 0;
		for(int i = 0; i<testClass; i++) {
			if(studentCnt[i]-mainT < 0) {
				Tcnt += 0;
			}else {
				Tcnt += (long)Math.ceil((double)(studentCnt[i]-mainT)/subT);
			}
			
		}
		sum = (long)Tcnt + testClass;
		System.out.println(sum);
	}

}
