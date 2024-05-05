package BAEK_14502_연구소_15w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, num, max;
	static int[][] map;
	static int[] tmp, tar, dc, dr;
	static boolean[][] check, tmpCheck;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //세로
		M = sc.nextInt(); //가로
		
		map = new int[N][M];
		check = new boolean[N][M];
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<M; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] != 0) {
					check[r][c] = true;
				}
			}
		}
//		for(int i = 0 ; i<N; i++) {
//			System.out.println(Arrays.toString(check[i]));
//		}
		
		//1 ~ N*M까지 뽑는데
		//그 좌표가 2 이거나 1 이면 바로 건너뛰기
		num = N*M;
		tar = new int[num];
		for(int i = 1; i<=num; i++) {
			tar[i-1] = i;
		}
		tmp = new int[3];
		tmpCheck = new boolean[N][M];
		dr = new int[] {-1, 1, 0, 0};
		dc = new int[] {0, 0, -1, 1};
		max = 0;
		combination(0, 0);
		

		
		
		

		System.out.println(max);

	}

	private static void count() {
		int cnt = 0;
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<M; c++) {
				if(!tmpCheck[r][c]) {
					cnt++;
				}
			}
		}
		if(max < cnt) {
			max = cnt;
		}
//		System.out.println(cnt);
		for(int i = 0; i<3; i++) {
			int n = tmp[i];
			int r = 0;
			int c = 0;
			if(n%M == 0) {
				c = M-1;
				r = n/M - 1;
			}else {
				r = n/M;
				c = n%M - 1;
			}
			map[r][c] = 0;
			tmpCheck[r][c] = false;
		}
	}

	private static void virus(int r, int c) {
		//받은 좌표 기준으로 4방탐색해서
		//2로 채우기
		for(int d = 0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr <N && nc>=0 && nc<M) {
				if(map[nr][nc] == 0 && !tmpCheck[nr][nc]) {
					tmpCheck[nr][nc] = true;
					virus(nr,nc);
				}
			}

		}
		
	}

	private static void combination(int idx, int sidx) {
		if(idx == 3) {
			for(int x = 0; x<N; x++) {
				for(int y = 0; y < M; y++) {
					tmpCheck[x][y] = check[x][y];
				}
			}
			for(int i = 0; i<3; i++) {
				int n = tmp[i];
				int r = 0;
				int c = 0;
				if(n%M == 0) {
					c = M-1;
					r = n/M - 1;
				}else {
					r = n/M;
					c = n%M - 1;
				}
				map[r][c] = 1;
				tmpCheck[r][c] = true;

			}
//			for(int j = 0; j<N; j++) {
//				System.out.println(Arrays.toString(tmpCheck[j]));
//			}
//			for(int j = 0; j<N; j++) {
//				System.out.println(Arrays.toString(map[j]));
//			}
//			System.out.println("tmp : "+ Arrays.toString(tmp));
			for(int x = 0; x<N; x++) {
				for(int y = 0; y<M; y++) {
					if(map[x][y] == 2) {
						virus(x, y);
					}
					
				}
			}
//			for(int i = 0; i<N; i++) {
//				System.out.println(Arrays.toString(tmpCheck[i]));
//			}
			count();
			return;
		}
		
		for(int i = sidx; i<num; i++) {
			int n = tar[i];
			int r = 0;
			int c = 0;
			if(n%M == 0) {
				c = M-1;
				r = n/M - 1;
			}else {
				r = n/M;
				c = n%M - 1;
			}
			if(map[r][c] == 0) {
				tmp[idx] = tar[i];
				combination(idx+1, i+1);
			}

			
		}
	}

}
