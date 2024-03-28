package BAEK_1074_Z_10w;

import java.util.Scanner;

public class Main {
	static int N, cnt, amount;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int arr[][] = new int [4][4];
		
		//N>1일 때, r,c가 몇 사분면에 있는지 check
		//2사분면 = r,c-(size/2)   cnt += N*N*0.25
		//3사분면 = r-(size/2), c  cnt += N*N*0.5
		//4사분면 = r-(size/2), c-(size/2) cnt += N*N*0.75
		//1사분면 = N-1, 다시 몇사분면인지 찾기
		
		//N == 1 일때 사분면 찾고 1사 = 0, 2사 = 1, 3사 = 2, 4사 = 3 cnt에 추가해주기
		cnt = 0;
		find(r, c);
		
	}
	private static void find(int r, int c) {
		amount = (int)Math.pow(2, N) * (int)Math.pow(2, N);
		int length = (int)Math.pow(2, N);
		//사분면 결정
		if(r<length/2 && c<length/2) {
			//1사분면
			if(N == 1) {
				System.out.println(cnt);
			}else {
				N -= 1;
				find(r, c);
			}
		}else if(r<length/2 && c>=length/2) {
			//2사분면
			cnt += amount * 0.25;
			if(N == 1) {
				System.out.println(cnt);
			}else {
				N -= 1;
				find(r,c-(length/2));
			}
		}else if(r>=length/2 && c<length/2) {
			//3사분면
			cnt += amount * 0.5;
			if(N == 1) {
				System.out.println(cnt);
			}else {
				N -= 1;
				find(r-(length/2), c);
			}
		}else {
			//4사분면
			cnt += amount * 0.75;
			if(N == 1) {
				System.out.println(cnt);
			}else {
				N -= 1;
				find(r-(length/2), c-(length/2));
			}
		}
		
	}

}
