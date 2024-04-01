package BAEK_2178_미로탐색_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Target{
		int r, c, cnt;

		public Target(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		
	}
	static int N, M;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dr, dc;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str= br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);

		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		arr = new char[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i<N; i++){
			str = br.readLine();
			char[] cha = str.toCharArray();
			for(int j = 0; j<M; j++) {
				arr[i][j] = cha[j];
				if(cha[j] == '0') {
					visited[i][j] = true;
				}
			}
		}
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
		
		
		dr = new int[] {-1, 1, 0, 0};
		dc = new int[] {0, 0, -1, 1};
		BFS(0, 0);
	}
	private static void BFS(int r, int c) {
		Queue<Target> q = new LinkedList<Target>();
		int cnt = 1;
		
		
		q.add(new Target(r, c, cnt));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Target tar = q.poll();
			
//			System.out.println(tar.r + " : "+tar.c);
			
			//4방탐색
			for(int d = 0; d<4; d++) {
				int nr = dr[d] + tar.r;
				int nc = dc[d] + tar.c;
				
				if((nr >= 0 && nr < N) && (nc >= 0 && nc < M)) {
					
					if(!visited[nr][nc]) {
						Target tar2 = new Target(nr, nc, tar.cnt+1);
						q.add(tar2);
						
						visited[nr][nc] = true;
						if(tar2.r == N-1 && tar2.c == M-1) {
							System.out.println(tar2.cnt);
						}
					}
				}
			}
			
		}
		
	}

}
