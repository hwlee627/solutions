package BAEK_17070_파이프옮기기1_14w;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pipe{
		int d, r, c;

		public Pipe(int d, int r, int c) {
			super();
			this.d = d;
			this.r = r;
			this.c = c;
		}
		
		
	}
	static int N, cnt;
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		for(int r = 0; r<N; r++) {
			for (int c = 0; c<N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		//파이프의 끝 좌표를 (r,c)로 둔다면,
		//가로 1 = 가로로 가거나(r,c+1), 대각선으로 가거나(r+1,c+1)
		//대각선 2 =  가로(r, c+1), 대각선(r+1, c+1), 세로(r+1, c)
		//세로 3 = 세로(r+1, c), 대각선(r+1, c+1)
		
		//목표 좌표는 (N,N)
		cnt = 0;
		if(map[N-1][N-1] == 1) {
			System.out.println(0);
		}else {
			check(0,1);
			System.out.println(cnt);
		}

		
	}
	private static void check(int r, int c) {
		Queue<Pipe> q = new LinkedList<>();
		Pipe pipe = new Pipe(1,0,1);
		q.add(pipe);
		while(!q.isEmpty()) {
			Pipe p = q.poll();
//			System.out.println("r : " +p.r + " c : " + p.c);
			if(p.r == N-1 && p.c == N-1) {
				cnt++;
			}else {
				if(p.r+1<N && p.c+1<N) {
					if(diagonal(p.r,p.c)) {
						q.add(new Pipe(2, p.r+1, p.c+1));
					}
					if(right(p.r, p.c) && p.d != 3) {
						q.add(new Pipe(1, p.r, p.c+1));
					}
					if(down(p.r, p.c) && p.d != 1) {
						q.add(new Pipe(3, p.r+1, p.c));
					}
				}else if(p.r+1<N) {
					if(down(p.r, p.c) && p.d != 1) {
						q.add(new Pipe(3, p.r+1, p.c));
					}
				}else if(p.c+1<N) {
					if(right(p.r, p.c) && p.d != 3) {
						q.add(new Pipe(1, p.r, p.c+1));
					}
				}
			}

		}

	}
	private static boolean down(int r, int c) {
		boolean check = true;
		if(map[r+1][c] != 0) {
			check = false;
		}
		return check;
	}
	private static boolean right(int r, int c) {
		boolean check = true;
		if(map[r][c+1] != 0) {
			check = false;
		}
		return check;
	}
	private static boolean diagonal(int r, int c) {
		boolean check = true;
		for(int i = r; i<=r+1; i++) {
			for(int j = c; j<=c+1; j++) {
				if(map[i][j] != 0) {
					check = false;
				}
			}
		}
		
		return check;
	}

}
