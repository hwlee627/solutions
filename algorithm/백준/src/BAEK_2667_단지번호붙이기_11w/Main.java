package BAEK_2667_단지번호붙이기_11w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int level, n, cnt;
	static int[] dr, dc, cnts;
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		sc.nextLine();
		
		arr = new int[n][n];
		visited = new boolean[n][n];
		for(int i = 0 ; i<n; i++) {
			String str = sc.nextLine();
//			System.out.println(str);
			char[] cha = str.toCharArray();
//			System.out.println(Arrays.toString(cha));
			for(int j = 0; j<n; j++) {
				
				arr[i][j] = Integer.parseInt(cha[j]+"");
				if(arr[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}
//		for(int r = 0; r<n; r++) {
//			System.out.println(Arrays.toString(arr[r]));
//		}
		dr = new int[] {-1,1,0,0};
		dc = new int[] {0,0,-1,1};
		level = 1;
		List<Integer> cntList = new ArrayList<Integer>();
		for(int r = 0; r<n; r++) {
			for(int c = 0; c<n; c++) {
				if(arr[r][c] == 1 && !visited[r][c]) {
					cnt = 1;
//					System.out.println("r : "+r+" c : "+c);
					visited[r][c] = true;
					arr[r][c] = level;
					find(r,c);
//					System.out.println(cnt+" "+level);
					cntList.add(cnt);
					level++;
				}
			}
		}
		Collections.sort(cntList);
		StringBuilder sb = new StringBuilder();
		sb.append(level-1+"\n");
		for(int a : cntList) {
			sb.append(a+"\n");
		}
		System.out.println(sb);
	}
	private static void find(int r, int c) {
		for(int d = 0; d<4; d++) {
			int nr = dr[d] + r;
			int nc = dc[d] + c;
			if((nr >= 0 && nr<n) && (nc >= 0 && nc<n)) {
				if(arr[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					arr[nr][nc] = level;
					find(nr, nc);
					cnt++;
				}
				
			}
		}
	}


}
