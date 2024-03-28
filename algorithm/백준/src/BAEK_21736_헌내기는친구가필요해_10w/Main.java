package BAEK_21736_헌내기는친구가필요해_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[][] school;
	static int[] dr, dc;
	static boolean [][] visited;
	static int cnt, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken()); //가로줄 수
			M = Integer.parseInt(st.nextToken()); //세로줄 수
		}
		visited = new boolean[N][M];
		school = new char[N][M];
		
		for(int i = 0; i<N; i++) {
			str = br.readLine();
			school[i] = str.toCharArray();
		}

		int x = 0;
		int y = 0;
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<M; c++) {
				if(school[r][c] == 'I') {
					y = r;
					x = c;
				}else if(school[r][c] == 'X') {
					visited[r][c] = true;
				}
			}
		}
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
		cnt = 0;
		dr = new int[] {-1,1,0,0};
		dc = new int[] {0,0,-1,1};
		findP(y,x);
		if(cnt == 0) {
			System.out.println("TT");
		}else {
			System.out.println(cnt);
		}
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
	}

	private static void findP(int r, int c) {
		visited[r][c] = true;

		if(school[r][c] == 'P') {
			cnt++;
		}
		for(int i = 0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			if((nr >= 0 && nr<N) && (nc >= 0 && nc<M) && !visited[nr][nc]){
				findP(nr,nc);
			}
		}

	}

}
