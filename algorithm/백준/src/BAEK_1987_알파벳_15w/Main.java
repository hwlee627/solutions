package BAEK_1987_알파벳_15w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int R, C, cnt, max;
	static char[][] arr;
	static HashSet<String> list;
	static int[] dr, dc;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		arr = new char[R][C];
		
		for(int r = 0; r<R; r++) {
			arr[r] = sc.nextLine().toCharArray();
		}
//		for(int r = 0; r<R; r++) {
//			for(int c = 0; c<C; c++) {
//				list.add((String)(arr[r][c]+""));
//			}
//		}
		dr = new int[] {-1,1,0,0};
		dc = new int[] {0,0,-1,1};
		max = 0;
		list = new HashSet<>();
		list.add((String)(arr[0][0]+""));
		visited = new boolean[R][C];
		visited[0][0] = true;
		BFS(0,0);
		System.out.println(max+1);
	}
	private static void BFS(int r, int c) {
		
		for(int d = 0; d<4; d++) {
			int nr = dr[d] + r;
			int nc = dc[d] + c;
			
			if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc]) {
				//System.out.println(list.contains((String)(arr[nr][nc]+"")));
				boolean check = list.add((String)(arr[nr][nc]+""));
				if(check) {
//					System.out.println("nr : "+nr + " nc : "+nc);
					visited[nr][nc] = true;
					BFS(nr,nc);
				}else {
					continue;
				}
			}
		}
		list.remove((String)(arr[r][c]+""));
		visited[r][c] = false;
		if(list.size()>max) {
			max = list.size();
		}
		
		
	}

}
