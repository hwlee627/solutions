package BAEK_21610_마법사상어와비바라기_12w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] dr, dc, dr2, dc2;
	static boolean[][] visited;
	static List<Cloud> list;
	static class Cloud{
		int r, c, dir;

		public Cloud(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //배열 크기
		M = sc.nextInt(); //이동 횟수
		
		
		arr = new int[N][N];
		
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				arr[r][c] = sc.nextInt();
				
			}
		}
		list = new ArrayList<Cloud>();
		for(int r = N-1; r>N-3; r--) {
			for(int c = 0; c<=1; c++) {
				Cloud cl = new Cloud(r,c,0);
				list.add(cl);
			}
		}
		//direction 용
		dr = new int[] {0,-1,-1,-1,0,1,1,1};
		dc = new int[] {-1,-1,0,1,1,1,0,-1};
		
		
		//물복사버그 대각선 탐색
		dr2 = new int[] {-1, -1, 1, 1};
		dc2 = new int[] {-1, 1, -1, 1};
		
		for(int i = 0; i<M; i++) {
			int direction = sc.nextInt()-1;
			int depth = sc.nextInt();
			visited = new boolean[N][N];
			rain(direction, depth);
			copyWater();
			makeCloud();
			for(int j = 0; j<N; j++) {
				System.out.println(Arrays.toString(arr[j]));
			}
			System.out.println();
		}

	}

	private static void makeCloud() {
		list = new ArrayList<Cloud>();
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				if(arr[r][c] >= 2 && !visited[r][c]) {
					arr[r][c] -= 2;
					System.out.println("r : " + r + " c : "+ c);
					Cloud cl = new Cloud(r, c, 0);
					list.add(cl);
				}
			}
		}
		
	}
	private static void copyWater() {
		for(Cloud c : list) {
			int cnt = 0;
			for(int d = 0; d<4; d++) {
				int nr = dr2[d] + c.r;
				int nc = dc2[d] + c.c;
				if(nr >= 0 && nr<N && nc>=0 && nc<N && arr[nr][nc] != 0) {
					cnt++;
				}
			}
			arr[c.r][c.c] += cnt;
		}
		
	}
	private static void rain(int direction, int depth) {
		for(Cloud c : list) {
			c.dir = direction;
		}
		//구름 이동
		for(Cloud c : list) {
			int nr = dr[direction]*depth + c.r;
			int nc = dc[direction]*depth + c.c;
			
			if(nr >= 0 && nr<N && nc>= 0 && nc<N) {
				c.r = nr;
				c.c = nc;
			}else if (nr>=N) {
				c.r = Math.abs(nr%N);
			}else if (nr<0) {
				c.r = N - Math.abs(nr%N);
			}else if(nc>=N) {
				c.c = Math.abs(nc%N);
			}else if(nc<0) {
				c.c = N - Math.abs(nc%N);
			}
		}
		//비 내리기
		for(Cloud c : list) {
			System.out.println("mr : " + c.r + " mc : " + c.c);
			visited[c.r][c.c] = true;
			arr[c.r][c.c]+= 1;
		}
	}

}
