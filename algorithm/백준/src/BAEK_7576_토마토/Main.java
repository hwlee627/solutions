package BAEK_7576_토마토;

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
	
	static int[][] arr;
	static int[] dr, dc;
	static int C, R, completeDay;
	static boolean[][] visited;
	static Queue<Node> q = new LinkedList<Node>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt();
		R = sc.nextInt();
		
		arr = new int[R][C];
		
		boolean isExist = false;
		visited = new boolean[R][C];
		for(int r = 0; r<R; r++) {
			for(int c = 0; c<C; c++) {
				arr[r][c] = sc.nextInt();
				if(arr[r][c] == 0) {
					isExist = true; //안 익은 토마토가 있는지 check
				}else if(arr[r][c] == 1) {
					visited[r][c] = true;
					Node start = new Node(r, c, 0);
					q.add(start);
				}else {
					visited[r][c] = true;
				}
			}
		}
		dr = new int[] {-1,1,0,0};
		dc = new int[] {0,0,-1,1};
		if(isExist) {
			find();
			boolean hasLeft = false;
			for(int r = 0; r<R; r++) {
				for(int c = 0; c<C; c++) {
					if(!visited[r][c]) {
						hasLeft = true;
					}
				}
			}
			if(hasLeft) {
				System.out.println(-1);
			}else {
				System.out.println(completeDay);
			}
		}else {
			//이미 다 익어있는 상태
			System.out.println(0);
		}

		


	}
	private static void find() {
		
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int d = 0; d<4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if((nr>=0 && nr<R)&&(nc>=0 && nc<C)) {
					if(arr[nr][nc] == 0 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						Node tar = new Node(nr,nc,node.days+1);
						completeDay = tar.days;
						q.add(tar);
					}
				}
			}
		}
	}

}
