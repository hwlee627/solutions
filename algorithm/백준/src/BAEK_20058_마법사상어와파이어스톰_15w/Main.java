package BAEK_20058_마법사상어와파이어스톰_15w;

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
	static boolean[][] checked;
	static int[][] map;
	static int[] dr, dc;
	static int length, ice;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		length = (int)Math.pow(2, N);
		map = new int[length][length];
		
		int Q = sc.nextInt();
		
		for(int r = 0; r<length; r++) {
			for(int c = 0; c<length; c++) {
				map[r][c] = sc.nextInt();
				
			}
		}
		int[] Larr = new int[Q];
		
		for(int i = 0; i<Q; i++) {
			Larr[i] = sc.nextInt();
		}
		dr = new int[] {-1, 1 , 0, 0};
		dc = new int[] {0, 0, -1, 1};
		
		int sum = 0;
		int max = 0;
		
		for(int i = 0; i<Q; i++) {
			List<Point> list = new ArrayList<>();
			int L = Larr[i];
			int[][] tmp = new int[length][length];
			for(int r = 0; r<length; r++) {
				for(int c = 0; c<length; c++) {
					tmp[r][c] = map[r][c];
				}
			}
			int num = (int)Math.pow(2, L);
			for(int r = 0; r<length; r++) {
				for(int c = 0; c<length; c++) {
					int divR = r/num;
					int divC = c/num;
					int modR = r%num;
					int modC = c%num;
					
					map[divR * num + modC][divC * num + (num-1)-modR] = tmp[r][c];
				}
			}
//			for(int r = 0; r<length; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
			for(int r = 0; r<length; r++) {
				for(int c = 0; c<length; c++) {
					int cnt = 0;
					for(int d = 0; d<4; d++) {
						int nr = dr[d] + r;
						int nc = dc[d] + c;
						if(nr>=0 && nr<length && nc>=0 && nc<length && map[nr][nc] != 0) {
							cnt++;
						}
					}
					if(cnt <3) {
						if(map[r][c] > 0) {
							list.add(new Point(r,c));
						}
						
					}
				}
			}
			for(Point p : list) {
				map[p.r][p.c]--;
			}
		}
		sum = 0;
		max = 0;
		checked = new boolean[length][length];
		for(int r = 0; r<length; r++) {
			for(int c = 0; c<length; c++) {
				if(map[r][c] == 0) {
					checked[r][c] = true;
				}
				if(!checked[r][c]) {
					ice = 1;
					bfs(r,c);
				}
				if(max < ice) {
					max = ice;
				}
				sum += map[r][c];
			}
		}

		System.out.println(sum);
		System.out.println(max);
		
	}

	private static void bfs(int r, int c) {
		checked[r][c] = true;
		for(int d = 0; d<4; d++) {
			int nr = dr[d] + r;
			int nc = dc[d] + c;
			
			if(nr >= 0 && nr<length && nc >=0 && nc<length && map[nr][nc] != 0 && !checked[nr][nc]) {
				checked[nr][nc] = true;
				ice++;
				bfs(nr,nc);
			}
		}
		
		
	}

}
