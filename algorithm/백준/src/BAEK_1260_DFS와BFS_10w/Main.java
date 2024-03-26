package BAEK_1260_DFS와BFS_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	private static int[][] nodes;
	private static boolean[] visited;
	private static int N, M, V;
	private static int cnt;
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str= br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
		}
		nodes = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i = 0; i<M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				nodes[r][c] = 1;
				nodes[c][r] = 1;
			}
		}
		
		q.add(V);
		DFS(V);
		System.out.println();
		visited = new boolean[N+1];
		cnt = 1;

		visited[V] = true;
		BFS(V);
		
		
	}
	private static void BFS(int v) {
		//큐가 공백이 될 때 까지 수행
		while(!q.isEmpty()) {
			int curr = q.poll(); //하나 꺼내 !
			System.out.print(curr+" "); //경로 보기
			
			for(int i = 1; i<=N; i++) {
				if(!visited[i] && nodes[curr][i] == 1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}
	private static void DFS(int start) {
		//start 노드 방문 처리
		visited[start] = true;
		System.out.print(start+" ");
		
		//인접한 노드 방문
		for(int i = 1; i<=N; i++) {
			if(!visited[i] && nodes[start][i] == 1) {
				DFS(i);
			}
		}
		
	}

}
