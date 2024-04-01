package BAEK_14940_쉬운최단거리_11w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int r, c, level;

		public Node(int r, int c, int level) {
			this.r = r;
			this.c = c;
			this.level = level;
		}
		
		
	}
	
	static boolean[][] visited;
	static int[][] map, levels;
	static int[] dr, dc;
	static int N, M, level;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		map = new int[N][M];
		visited = new boolean[N][M];
		levels = new int[N][M];
		level = 0;
		
		dr = new int[] {-1,1,0,0};
		dc = new int[] {0,0,-1,1};
		
		for(int i = 0; i<N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int idx = 0;
			while(st.hasMoreTokens()) {
				map[i][idx] = Integer.parseInt(st.nextToken());
				if(map[i][idx] == 0) {
					visited[i][idx] = true;
				}
				idx++;
				
			}
		}
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<M; c++) {
				if(map[r][c] == 2) {
					visited[r][c] = true;
					BFS(r,c);
				}
			}
		}
	}
	private static void BFS(int r, int c) {
		Queue<Node> q = new LinkedList<Node>();
		Node node = new Node(r, c, level);
		q.add(node);
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(int d = 0; d<4; d++) {
				int nr = dr[d] + curr.r;
				int nc = dc[d] + curr.c;
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(map[nr][nc] == 1 && !visited[nr][nc]) {
						Node no = new Node(nr,nc,curr.level+1);
						visited[nr][nc] = true;
						levels[nr][nc] = no.level;
						
						q.add(no);
					}
				}
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(visited[i][j] == false) {
					levels[i][j] = -1;
				}
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				sb.append(levels[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
