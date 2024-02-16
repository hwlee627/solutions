package 퇴사_bj_14501_4w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int upCnt = 0;
		int downCnt = 0;
		int tmp = 0;
		for(int i = 0; i<8; i++) {
			int num = sc.nextInt();
			if(i >= 1) {
				if(tmp > num) {
					downCnt++;
					tmp = num;
				}if(tmp < num) {
					upCnt++;
					tmp = num;
				}
			}else {
				tmp = num;
				upCnt++;
				downCnt++;
			}
		}
		if(downCnt == 8) {
			System.out.println("descending");
		}else if(upCnt == 8) {
			System.out.println("ascending");
		}else {
			System.out.println("mixed");
		}
		
	}
}
