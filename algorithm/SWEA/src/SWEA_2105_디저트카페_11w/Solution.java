package SWEA_2105_디저트카페_11w;

import java.util.Scanner;

public class Solution {
	static int[][] map;
	static int[] dr, dc, dr2, dc2, tmp;
	static int cnt, N, max;
	static boolean isOk;
	static boolean[] desert;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			max = 0;
			N = sc.nextInt();
			
			map = new int[N][N];
			
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			dr = new int[] {-1,1,0,0}; //상하좌우
			dc = new int[] {0,0,-1,1};
			
			dr2 = new int[] {-1, -1, 1, 1}; // 대각 탐색용
			dc2 = new int[] {-1, 1, -1, 1};
			
			for(int r = 1; r<N-1; r++) {
				for(int c = 1; c<N-1; c++) {
					cnt = 0;
					visited = new boolean[N][N];
					desert = new boolean[101];
					find(r, c);
				}
			}
			if(max == 0) {
				System.out.println(-1);
			}else {
				System.out.println(max);
			}
			
		}

	}
	private static void find(int r, int c) {
		isOk = true;
//		System.out.println("r : " + r +" c : "+ c);
		for(int d = 0; d<4; d++) {
			int nr = dr[d] + r;
			int nc = dc[d] + c;
			if(!visited[nr][nc] && !desert[map[nr][nc]]) {
				visited[r][c] = true;
				visited[nr][nc] = true;
				desert[map[nr][nc]] = true;
				cnt++;
			}else if(!visited[nr][nc] && desert[map[nr][nc]]) {
				isOk = false;
			}
		}
		if(isOk) {
//			System.out.println(cnt);
			for(int d = 0; d<4; d++) {
				int nr = dr2[d] + r;
				int nc = dc2[d] + c;
				if(nr>=1 && nr<N-1 && nc>=1 && nc<N-1 && !visited[nr][nc]) {
//					System.out.println("nr : "+nr + " nc : "+nc);
					find(nr,nc);
					
				}
			}
		}else {
			
			return;
		}
		if(max<cnt) {
			max = cnt;
		}
		return;
	}

}
