package BAEK_7569_토마토_11w;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node{
		int r, c, days;

		public Node(int r, int c, int days) {
			
			this.r = r;
			this.c = c;
			this.days = days;
		}
		
	}
	static int C, R, level, maxDays;
	static int[][] arr;
	static int[] dr, dc;
	static boolean[][] visited;
	static Queue<Node> q= new LinkedList<Node>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt();
		R = sc.nextInt();
		level = sc.nextInt();
		
		arr = new int[R*level][C];
		visited = new boolean[R*level][C];
		
		boolean isExist = false;
		dr = new int[] {-1,1,R,-R,0,0}; //상 하 위 아래 좌 우
		dc = new int[] {0,0,0,0,-1,1};
		
		for(int r = 0; r<R*level; r++) {
			for(int c = 0; c<C; c++) {
				arr[r][c] = sc.nextInt();
				if(arr[r][c] == 1) {
					visited[r][c] = true;
					Node start = new Node(r,c,0);
					q.add(start);
				}else if(arr[r][c] == 0) {
					isExist = true;
				}else {
					visited[r][c] = true;
				}
			}
		}
		

		
		if(isExist) {
			find();
			boolean hasLeft = false;
			
			for(int r = 0; r<R*level; r++) {
				for(int c = 0; c<C; c++) {
					if(!visited[r][c]) {
						hasLeft = true;
					}
				}
			}
			if(hasLeft) {
				System.out.println(-1);
			}else {
				System.out.println(maxDays);
			}
			
//			for(int r= 0; r<R*level; r++) {
//				System.out.println(Arrays.toString(visited[r]));
//			}
		}else {
			System.out.println(0);
		}
	}
	private static void find() {
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int d = 0; d<6; d++) {
				int nr = dr[d] + node.r;
				int nc = dc[d] + node.c;
				
				if((nr>=0 && nr<R*level)&&(nc>=0 && nc<C)) {
					if(d == 0 && nr%R == (R-1)) {
						
					}else if(d == 1 && nr%R == 0){
						
					}else {
						if(arr[nr][nc] == 0 && !visited[nr][nc]) {
							visited[nr][nc] = true;
							Node tar = new Node(nr,nc,node.days+1);
							q.add(tar);
							maxDays=tar.days;
						}
					}
				}
			}
		}
		
	}
	
}
