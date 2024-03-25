package BAEK_1012_유기농배추_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[][] farm;
	private static int[] dr, dc;
	private static boolean[][] visited;
	private static int warm, R, C = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			warm = 0;
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int cnt = 0;
			while(st.hasMoreTokens()) {
				R = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());
				cnt = Integer.parseInt(st.nextToken());
			}
			farm = new int[R][C];
			visited = new boolean[R][C];
			dr = new int[] {-1,1,0,0};
			dc = new int[] {0,0,-1,1};
			
			for(int i = 0; i<cnt; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				while(st.hasMoreTokens()) {
					farm[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
				}
			}
			for(int r = 0; r<R; r++) {
				for(int c = 0; c<C; c++) {
					if(farm[r][c] == 1 && visited[r][c] == false) {
						warm++;
						find(r, c);
					}
				}
			}
//			for(int r = 0; r<R; r++) {
//				for(int c = 0; c<C; c++) {
//					System.out.printf("%3d", farm[r][c]);
//				}
//				System.out.println();
//			}
//			
//			for(int r = 0; r<R; r++) {
//				System.out.println(Arrays.toString(visited[r]));
//			}
			System.out.println(warm);
		}

	}

	private static void find(int r, int c) {
		visited[r][c] = true;
		for(int d = 0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if((nr >= 0 && nr < R)&&(nc >= 0 && nc < C)) {
				if(farm[nr][nc] == 1 && visited[nr][nc] == false) {
					find(nr, nc);
				}
			}
		}
		
	}

}
