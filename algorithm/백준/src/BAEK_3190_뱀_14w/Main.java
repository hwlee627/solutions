package BAEK_3190_뱀_14w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Direction{
		int s, d;

		public Direction(int s, int d) {
			super();
			this.s = s;
			this.d = d;
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
	static List<Direction> directionList;
	static int[][] map;
	static boolean[][] snake;
	static int[] dr, dc;
	static int N, L, appleCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//기본은 오른쪽을 향함
		dr = new int[] {0, 1, 0, -1};
		dc = new int[] {1, 0, -1, 0};
		
		
		N = sc.nextInt();
		appleCnt = sc.nextInt();
		
		map = new int[N][N];
		snake = new boolean[N][N];
		//사과 위치 받기
		for(int i = 0; i<appleCnt; i++) {
			map[sc.nextInt()-1][sc.nextInt()-1] = 1;
		}
		L = sc.nextInt();
		directionList = new ArrayList<Main.Direction>();
		//방향 정보
		for(int i = 0; i<L; i++) {
			int second = sc.nextInt();
			String direction = sc.next();
			if(direction.equals("D")) {
				directionList.add(new Direction(second, 1));
			}else if(direction.equals("L")){
				directionList.add(new Direction(second, -1));
			}
		}
//		for(int r = 0; r<N; r++) {
//			System.out.println(Arrays.toString(map[r]));
//		}
		dummy();
	}
	private static void dummy() {
		Queue<Point> q = new LinkedList<Main.Point>();
		int dir = 0;
		int time = 0;
		int currR = 0;
		int currC = 0;
		q.add(new Point(0, 0));
		snake[0][0] = true;
		
		while(true) {
			time++;
			int nr = dr[dir] + currR;
			int nc = dc[dir] + currC;
//			System.out.println("nr : "+nr+" nc : "+nc);
			//벽박
			if(nr <0 || nr>=N || nc<0 || nc>=N) {
				System.out.println(time);
				break;
			}else if(snake[nr][nc]) {
				System.out.println(time);
				break;
			}
			if(map[nr][nc] != 0) {
				map[nr][nc] = 0;
				q.add(new Point(nr,nc));
				snake[nr][nc] = true;
				currR = nr;
				currC = nc;
			}else {
				Point p = q.poll();
				snake[p.r][p.c] = false;
				q.add(new Point(nr,nc));
				snake[nr][nc] = true;
				currR = nr;
				currC = nc;
			}
			for(Direction d : directionList) {
				if(time == d.s) {
					dir += d.d;
				}
				if(dir == 4) {
					dir = 0;
				}
				if(dir < 0) {
					dir = 3;
				}
			}
		}
	}

}
