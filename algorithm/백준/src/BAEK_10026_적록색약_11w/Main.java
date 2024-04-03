package BAEK_10026_적록색약_11w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int r, c;

		public Node(int r, int c) {
			
			this.r = r;
			this.c = c;
		}
		
	}
	static char[][] arr;
	static int[] dr, dc;
	static int cnt, cbCnt, N ;
	static boolean[][] visited, cbvisited;
	static Queue<Node> q = new LinkedList<Node>();
	static Queue<Node> cbq = new LinkedList<Node>();
 	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		visited = new boolean[N][N];
		cbvisited = new boolean[N][N];
		
		for(int r = 0; r<N; r++) {
			String str = br.readLine();
			arr[r] = str.toCharArray();
		}
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		dr = new int[] {-1,1,0,0};
		dc = new int[] {0,0,-1,1};
		cnt = 0;
		cbCnt = 0;
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				if(!visited[r][c]) {
					visited[r][c] = true;
					Node node = new Node(r,c);
					q.add(node);
					find(r,c);
					
				}
				if(!cbvisited[r][c]) {
					cbvisited[r][c] = true;
					Node node = new Node(r,c);
					cbq.add(node);
					cbfind(r,c);
				}
			}
		}
//		for(int i = 0; i<N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
		System.out.println(cnt+" "+cbCnt);
		

	}
	private static void cbfind(int r, int c) {
		char value = arr[r][c];
		cbCnt++;
		
		while(!cbq.isEmpty()) {
			Node node = cbq.poll();
			if(value == 'R' || value == 'G') {
				for(int d = 0; d<4; d++) {
					int nr = dr[d] + node.r;
					int nc = dc[d] + node.c;
					if((nr>=0 && nr<N)&&(nc>=0 && nc<N)) {
						if(!cbvisited[nr][nc] && (arr[nr][nc] != 'B')) {
							cbvisited[nr][nc] = true;
							Node tar = new Node(nr, nc);
							cbq.add(tar);
						}
					}
				}
			}else {
				for(int d = 0; d<4; d++) {
					int nr = dr[d] + node.r;
					int nc = dc[d] + node.c;
					if((nr>=0 && nr<N)&&(nc>=0 && nc<N)) {
						if(!cbvisited[nr][nc] && (arr[nr][nc] == value)) {
							cbvisited[nr][nc] = true;
							Node tar = new Node(nr, nc);
							cbq.add(tar);
						}
					}
				}
			}
		}
		
	}
	private static void find(int r, int c) {
		char value = arr[r][c];
//		System.out.println("r : "+r+" c : "+c);
		cnt++;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int d = 0; d<4; d++) {
				int nr = dr[d] + node.r;
				int nc = dc[d] + node.c;
				if((nr>=0 && nr<N)&&(nc>=0 && nc<N)) {
					if(!visited[nr][nc] && (arr[nr][nc] == value)) {
						visited[nr][nc] = true;
						Node tar = new Node(nr, nc);
						q.add(tar);
					}
				}
			}
		}
		

		
	}

}
