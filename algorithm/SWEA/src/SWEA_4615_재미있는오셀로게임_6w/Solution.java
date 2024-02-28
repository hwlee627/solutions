package SWEA_4615_재미있는오셀로게임_6w;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			// 판 크기
			int N = sc.nextInt();
			// 플레이 할 횟수
			int M = sc.nextInt();

			int[][] board = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					board[r][c] = 0; // 0은 빈칸
				}
			}
			if (N == 4) {
				board[1][1] = 2;
				board[1][2] = 1;
				board[2][2] = 2;
				board[2][1] = 1;
			} else if (N == 6) {
				board[2][2] = 2;
				board[2][3] = 1;
				board[3][3] = 2;
				board[3][2] = 1;
			} else {
				board[3][3] = 2;
				board[3][4] = 1;
				board[4][4] = 2;
				board[4][3] = 1;
			}

//			for(int r = 0; r<N; r++) {
//				for(int c = 0; c<N; c++) {
//					System.out.print(board[r][c]);
//				}
//				System.out.println();
//			}
			int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
			int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

			for (int i = 1; i <= M; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int color = sc.nextInt();
				board[x][y] = color;

				for (int d = 0; d < 8; d++) {
					int nr = dr[d] + x;
					int nc = dc[d] + y;
					if ((0 <= nr && nr < N) && (0 <= nc && nc < N)) {
						List<Integer> list = new ArrayList<Integer>();
						for (int l = 1; l < N; l++) {
							nr = dr[d] * l + x;
							nc = dc[d] * l + y;
							if ((0 <= nr && nr < N) && (0 <= nc && nc < N)) {
								list.add(board[nr][nc]);
							}
						}
//						for (int num : list) {
//							System.out.print(num);
//						}
//						System.out.println();
						int cnt = 0;
						boolean check = false;
						for (int num : list) {
							// 흑돌일 때
							if (color == 1) {
								if (num == 1) {
									check = true;
									break;
								} else if(num == 0){
									break;
								}else {
									cnt++;
								}
								// 백돌일 때
							} else if (color == 2) {
								if (num == 2) {
									check = true;
									break;
								} else if(num == 0){
									break;
								}else {
									cnt++;
								}
							}
						}
						if (check) {
							if (cnt != 0) {
								for (int l = 1; l <= cnt; l++) {
									
									nr = dr[d] * l + x;
									nc = dc[d] * l + y;
									board[nr][nc] = color;
								}
							}
						}

					}
				}
			}
			int bCnt = 0;
			int wCnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(board[r][c] == 1) {
						bCnt++;
					}else if(board[r][c] == 2) {
						wCnt++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+bCnt+" "+wCnt);
		}

	}

}
