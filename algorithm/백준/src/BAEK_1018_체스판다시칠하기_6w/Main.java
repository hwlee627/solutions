package BAEK_1018_체스판다시칠하기_6w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		sc.nextLine();
		
		char[][] board = new char[R][C];
		for(int r = 0; r<R; r++) {
			String str = sc.nextLine();
			for(int c = 0; c<C; c++) {
				board[r][c] = str.charAt(c);
			}
		}
//		
//		for(int r = 0; r<R; r++) {
//			for(int c = 0; c<C; c++) {
//				System.out.print(board[r][c]);
//			}
//			System.out.println();
//		}
		
		//체스판 생성
		char[][] chess = new char[8][8];
		int min = Integer.MAX_VALUE;
		for(int r = 0; r<R-7; r++) {
			for(int c = 0; c<C-7; c++) {
				int chessRidx = 0;
				int cnt1 = 0;
				int cnt2 = 0;
				int cnt = 0;
				for(int i = r; i<r+8; i++) {
					int chessCidx = 0;
					for(int j = c; j<c+8; j++) {
						chess[chessRidx][chessCidx] = board[i][j];
						chessCidx++;
					}
					chessRidx++;
				}
				if(chess[0][0] == 'B') {
					cnt2++;
				}else {
					cnt1++;
				}
				int check = 0;
				if(check == 0) {
					chess[0][0] = 'B';
					for(int i = 0; i<8; i++) {
						for(int j = 0; j<8; j++) {
							if(i%2==0) {
								if(j%2==0) {
									if(chess[i][j] != 'B') {
										cnt1++;
									}
								}else {
									if(chess[i][j]!= 'W') {
										cnt1++;
									}
								}
							}else {
								if(j%2==0) {
									if(chess[i][j] != 'W') {
										cnt1++;
									}
								}else {
									if(chess[i][j]!= 'B') {
										cnt1++;
									}
								}
							}
						}
					}
					check = 1;
				}
				if(check == 1) {
					chess[0][0] = 'W';
					for(int i = 0; i<8; i++) {
						for(int j = 0; j<8; j++) {
							if(i%2==0) {
								if(j%2==0) {
									if(chess[i][j] != 'W') {
										cnt2++;
									}
								}else {
									if(chess[i][j]!= 'B') {
										cnt2++;
									}
								}
							}else {
								if(j%2==0) {
									if(chess[i][j] != 'B') {
										cnt2++;
									}
								}else {
									if(chess[i][j]!= 'W') {
										cnt2++;
									}
								}
							}
						}
					}
					check++;
				}
				if(cnt1>=cnt2) {
					cnt = cnt2;
				}else {
					cnt = cnt1;
				}
				
				if(min>cnt) {
					min = cnt;
				}
			}
			
		}
		System.out.println(min);
		
		
	}

}
