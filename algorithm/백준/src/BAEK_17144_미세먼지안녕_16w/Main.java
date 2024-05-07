package BAEK_17144_미세먼지안녕_16w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Dirt{
		int v, p; //원래 미세먼지의 양, 확산으로 받은 먼지의 양

		public Dirt(int v, int p) {
			super();
			this.v = v;
			this.p = p;
		}
		
		
		
	}
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//확산을 시킬 때, 확산하는 미세먼지의 양을 먼저 구한 후
		//기존에 미세먼지가 존재했던 칸에 덧셈을 해야함
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();
		
		Dirt[][] map = new Dirt[R][C];
		List<Integer> cleaner = new ArrayList<>();
		
		for(int r = 0; r<R; r++) {
			for(int c = 0; c<C; c++) {
				map[r][c] = new Dirt(sc.nextInt(), 0);
				if(map[r][c].v == -1) {
					cleaner.add(r);
				}
			}
		}
		//cleaner의 0번은 공기청정기의 위쪽
		//cleaner의 1번은 공기청정기의 아래쪽
		
//		for(int r = 0; r<R; r++) {
//			for(int c = 0; c<C; c++) {
//				System.out.print(map[r][c].v);	
//			}
//			System.out.println();
//			
//		}
		int[] dr = new int[] {-1, 1, 0, 0};
		int[] dc = new int[] {0, 0, -1, 1};
		int time = 0;
		while(time != T) {
			//확산
			for(int r = 0; r<R; r++) {
				for(int c = 0; c<C; c++) {
					if(map[r][c].v != -1 && map[r][c].v != 0) {
						int cnt = 0;
						for(int d = 0; d<4; d++) {
							int nr = dr[d] + r;
							int nc = dc[d] + c;
							
							if(nr >= 0 && nr<R && nc>= 0 && nc<C && map[nr][nc].v != -1) {
								cnt++;
							}
						}
						//개수 나오면
						int num = map[r][c].v / 5;
						map[r][c].v = map[r][c].v - (num * cnt);
						for(int d = 0; d<4; d++) {
							int nr = dr[d] + r;
							int nc = dc[d] + c;
							
							if(nr >= 0 && nr<R && nc>= 0 && nc<C && map[nr][nc].v != -1) {
								map[nr][nc].p += num;
							}
						}
					}
				}
			}
			
			for(int r = 0; r<R; r++) {
				for(int c = 0; c<C; c++) {
					map[r][c].v = map[r][c].v + map[r][c].p;
					map[r][c].p = 0;
				}
			}
//			for(int r = 0; r<R; r++) {
//			for(int c = 0; c<C; c++) {
//				System.out.print(map[r][c].v+" ");	
//			}
//			System.out.println();
//			
//		}
			//옮겨주기
			//시작점, 꼭지점
			//꼭지점 값부터 옮기기 
			Dirt[][] tmpMap = new Dirt[R][C];
			for(int r = 0; r<R; r++) {
				for(int c = 0; c<C; c++) {
					tmpMap[r][c] = map[r][c];
				}
			}
			for(int c = 2; c<C; c++) {
				map[cleaner.get(0)][c].v = tmpMap[cleaner.get(0)][c-1].v;
			}
			map[cleaner.get(0)][1].v = 0;
			
			for(int r = cleaner.get(0)-1; r>=0; r--) {
				map[r][C-1].v = tmpMap[r+1][C-1].v;
			}
			
			
			
			
			time++;
		}
		
	}

}
