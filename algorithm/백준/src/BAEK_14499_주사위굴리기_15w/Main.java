package BAEK_14499_주사위굴리기_15w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Dice{
		int s, v;

		public Dice(int s, int v) {
			super();
			this.s = s;
			this.v = v;
		}
		
	}
	static class DicePoint{
		int r, c, b;

		public DicePoint(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	static int N, M;
	static int[] dr, dc;
	static int[][] map;
	static int[] checkDice;
	static DicePoint initial;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //지도의 세로길이
		M = sc.nextInt(); //지도의 가로길이
		
		dr = new int[] {0,0,-1,1}; //동서북남
		dc = new int[] {1,-1,0,0};
		int bottom = 5;
		initial = new DicePoint(sc.nextInt(), sc.nextInt());
		
		int orderCnt = sc.nextInt();
		
		map = new int[N][M];
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		//밑 위 동 서 북 남
		checkDice = new int[6];
		
		for(int i = 0; i<orderCnt; i++) {
			int direction = sc.nextInt() - 1;
			moveDice(direction);
				
		}
		
		
	}
	private static void moveDice(int direction) {
		int nr = initial.r + dr[direction];
		int nc = initial.c + dc[direction];
//		System.out.println("nr : "+nr+" nc : "+nc);
		if(nr >=0 && nr<N && nc>=0 && nc<M) {
			initial.r = nr;
			initial.c = nc;
			//밑면이 주사위의 어떤 면인지 계산
			//기존의 주사위 상태 저장
			int[] tmp = Arrays.copyOf(checkDice, 6);
			if(direction == 0) {
				checkDice[0] = tmp[2];
				checkDice[1] = tmp[3];
				checkDice[2] = tmp[1];
				checkDice[3] = tmp[0];
				checkDice[4] = tmp[4];
				checkDice[5] = tmp[5];
			}else if(direction == 1) {
				checkDice[0] = tmp[3];
				checkDice[1] = tmp[2];
				checkDice[2] = tmp[0];
				checkDice[3] = tmp[1];
				checkDice[4] = tmp[4];
				checkDice[5] = tmp[5];
			}else if(direction == 2) {
				checkDice[0] = tmp[4];
				checkDice[1] = tmp[5];
				checkDice[2] = tmp[2];
				checkDice[3] = tmp[3];
				checkDice[4] = tmp[1];
				checkDice[5] = tmp[0];
			}else if(direction == 3) {
				checkDice[0] = tmp[5];
				checkDice[1] = tmp[4];
				checkDice[2] = tmp[2];
				checkDice[3] = tmp[3];
				checkDice[4] = tmp[0];
				checkDice[5] = tmp[1];
			}
			
			if(map[nr][nc] == 0) {
				map[nr][nc] = checkDice[0];
			}else {
				checkDice[0] = map[nr][nc];
				map[nr][nc] = 0;
			}
			System.out.println(checkDice[1]);
		}else {
			return;
		}

		
	}

}
