package BAEK_16234_인구이동_15w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	static int[] dr, dc;
	static int[][] map;
	static int mindepth, maxdepth, N, cnt, sum, days;
	static boolean[][] check, tmpCheck;
	static List<Point> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		dr = new int[] {-1, 1, 0, 0};
		dc = new int[] {0, 0, -1, 1};
		mindepth = sc.nextInt();
		maxdepth = sc.nextInt();
		
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		days = 0;
		while(true) {
			check = new boolean[N][N];
			boolean daysCheck = false;
//			System.out.println("new !!!!!!!!");
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					if(!check[r][c]) {
						sum = 0;
						list = new ArrayList<Main.Point>();
						list.add(new Point(r, c));
						cnt = 0;
						bfs(r, c);
						if(cnt != 0) {
							for(Point p : list) {
								map[p.r][p.c] = sum / cnt;
							}
						}
//						for(int i = 0; i<N; i++) {
//							System.out.println(Arrays.toString(map[i]));
//						}
//						System.out.println("cnt : "+cnt);
//						for(int i = 0; i<N; i++) {
//							System.out.println(Arrays.toString(check[i]));
//						}
						if(cnt != 0) {
							daysCheck = true;
						}
					}
					
				}
			}
			if(daysCheck) {
				days++;
			}else {
				break;
			}

		}
		System.out.println(days);

	}

	private static void bfs(int r, int c) {
		for(int i = 0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			
			if(nr >= 0 && nr<N && nc >= 0 && nc<N) {
				if(!check[nr][nc] && Math.abs(map[r][c] - map[nr][nc])<=maxdepth && Math.abs(map[r][c] - map[nr][nc])>=mindepth ) {
					cnt++;
					list.add(new Point(nr, nc));
					check[nr][nc] = true;
					sum += map[nr][nc];
//					System.out.println("sum : " + sum);
					bfs(nr,nc);
				}
			}
		}
	}

}
