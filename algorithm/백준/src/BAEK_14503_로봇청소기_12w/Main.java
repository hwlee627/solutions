package BAEK_14503_로봇청소기_12w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class Robot{
		int r, c, direction;

		public Robot(int r, int c, int direction) {
			
			this.r = r;
			this.c = c;
			this.direction = direction;
		}
		
		
	}
	static Robot rt;
	static int[] dr, dc;
	static int[][] floor;
	static boolean[][] visited;
	static int cnt;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		
		
		floor = new int[R][C];
		visited = new boolean[R][C];
		//0 : 북 1 : 서 2: 남 3 : 동
		rt = new Robot(sc.nextInt(), sc.nextInt(), sc.nextInt());
		if(rt.direction == 1) {
			rt.direction = 3;
		}else if(rt.direction == 3) {
			rt.direction = 1;
		}
		
		for(int r = 0; r<R; r++) {
			for(int c = 0; c<C; c++) {
				floor[r][c] = sc.nextInt();
				if(floor[r][c] == 1) {
					visited[r][c] = true;
				}
			}
		}
//		for(int i = 0; i<R; i++) {
//			System.out.println(Arrays.toString(floor[i]));
//		}
		dr = new int[] {-1, 0, 1, 0}; //상 좌 하 우 (반시계)
		dc = new int[] {0, -1, 0, 1};
		
		cnt = 0;
		int cnt2 = 0;
		cleaning(rt.r, rt.c);
//		for(int i = 0; i<R; i++) {
//			for(int j = 0; j<C; j++) {
//				System.out.print(floor[i][j]);
//				if(floor[i][j] == 2) {
//					cnt2++;
//				}
//			}
//			System.out.println();
//		}
//		System.out.println(cnt2);
	}
	private static void cleaning(int r, int c) {
		if(floor[r][c] == 0 && !visited[r][c]) {
			visited[r][c] = true;
			floor[r][c] = 2;
			cnt++;
		}
		int check = 0;
		boolean empty = false;
		loop : for(int d = 0; d<4 ; d++) {
			if(check == 4) {
				break loop;
			}else {
				int nr = dr[d]+rt.r;
				int nc = dc[d]+rt.c;
				if(floor[nr][nc] == 0 && !visited[nr][nc]) {
					empty = true;
					break loop;
				}
			}
		}
		if(empty) {
			rt.direction = (rt.direction+1)%4;
			for(int d = rt.direction; ;d++) {
				d = d%4;
				int nr = dr[d] + rt.r;
				int nc = dc[d] + rt.c;
				if(floor[nr][nc] == 0 && !visited[nr][nc]) {
					rt.r = nr;
					rt.c = nc;
					rt.direction = d%4;
					cleaning(rt.r, rt.c);
					return;
				}
			}
		}else {
			int num = (rt.direction + 2)%4;
			int nr = dr[num] + rt.r;
			int nc = dc[num] + rt.c;
			if(floor[nr][nc] != 1) {
				rt.r = nr;
				rt.c = nc;
				cleaning(rt.r, rt.c);
				return;
			}else if(floor[nr][nc] == 1) {
				System.out.println(cnt);
			}
		}
	}

}
