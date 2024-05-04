package BAEK_21610_마법사상어와비바라기_12w;

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
	static int[][] map;
	static boolean[][] cloud;
	static List<Point> cloudList;
	static int[] dr, dc, dr2, dc2;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		cloud = new boolean[N][N];
		int moveCnt = sc.nextInt();
		//구름 이동 델타배열
		dr = new int[] {0, -1, -1, -1, 0, 1, 1, 1}; //0 ~ 7
		dc = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
		//구름 이동 완료 후 대각선 탐색 델타배열
		dr2 = new int[] {-1, -1, 1, 1};
		dc2 = new int[] {-1, 1, -1, 1};
		
		
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		//맨 처음 구름
		//(N,1) (N,2) (N-1, 1) ( N-1,2)
		cloud[N-1][0] = cloud[N-1][1] = cloud[N-2][0] = cloud[N-2][1] = true;
		cloudList = new ArrayList<Main.Point>();
		for(int i = 0; i<moveCnt; i++) {
			int direction = sc.nextInt() -1;
			int depth = sc.nextInt();
			if(depth > N) {
				depth = depth % N;
			}
			
			callRain(direction, depth);
		}
		
		int ans = 0;
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				ans += map[r][c];
			}
		}
		System.out.println(ans);
	}
	private static void callRain(int direction, int depth) {
		//구름 좌표 받기
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				if(cloud[r][c]) {
					Point p = new Point(r,c);
					cloudList.add(p);
				}
			}
		}
		
		//임시 구름 리스트 추가
		List<Point> tmpList = new ArrayList<Main.Point>();
		//구름의 방향과 칸수 받아서 구름 이동
		for(Point p : cloudList) {
			//탐색 시작했으니 기존에 담아놨던 구름 boolean 배열 각각 초기화 해주기
			cloud[p.r][p.c] = false;
			p.r = p.r + dr[direction] * depth;
			p.c = p.c + dc[direction] * depth;
			
			if(p.r >= N) {
				p.r = p.r -N;
			}else if(p.r < 0) {
				p.r = p.r + N;
			}
			if(p.c >= N) {
				p.c = p.c -N;
			}else if(p.c < 0) {
				p.c = p.c + N;
			}
			tmpList.add(new Point(p.r, p.c));
			//이동 완료 하면 비 내리기
			map[p.r][p.c]++;
			
		}
		
		//이동완료한 구름 좌표가 있음
		for(Point p : tmpList) {
			//대각 탐색용 카운트
			int count = 0;
			//대각선 탐색 후 물 있는 개수 세서 물 추가
			for(int i = 0; i<4; i++) {
				int nr = dr2[i]+p.r;
				int nc = dc2[i]+p.c;
				//경계조건
				if(nr>=0 && nr<N && nc>=0 && nc<N) { 
					if(map[nr][nc] != 0) {
						//물이 있다면 카운트 세기
						count++;
					}
				}
			}
			//대각 탐색 후 물 있던 칸 수 만큼 증가시키기
//			System.out.println("count : " + count);
			map[p.r][p.c] += count;
			cloud[p.r][p.c] = true;
		}
//		for(int r = 0; r<N; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
//		System.out.println();
		//초기화 하고 (어차피 밑에서는 cloud boolean 배열의 T/F로 기존 구름이 있던 곳을 특정하기 때문
		 cloudList = new ArrayList<Main.Point>();
		//새로운 구름 찾기
		//구름이 있었던 칸 제외하고 나머지 칸 중 물의 양이 2 이상인 곳
		//생기면 2 줄어듬
//		 for(int r = 0; r<N; r++) {
//			 System.out.println(Arrays.toString(cloud[r]));
//		 }
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				if(!cloud[r][c] && map[r][c] >= 2) {
					map[r][c] -= 2;
					cloudList.add(new Point(r, c));
				}
			}
		}
//		for(int r = 0; r<N; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
		//새로운 구름을 담았다면, cloud boolean 배열 설정
		for(Point p : tmpList) {
			cloud[p.r][p.c] = false;
//			System.out.println("tmpList : "+p.r+" "+p.c);
		}
		for(Point p : cloudList) {
			cloud[p.r][p.c] = true;
//			System.out.println("cloudList : "+p.r + " "+p.c);
		}
//		for(int r = 0; r<N; r++) {
//			System.out.println(Arrays.toString(cloud[r]));
//		}
		cloudList = new ArrayList<Main.Point>();
	}

	
	

}
