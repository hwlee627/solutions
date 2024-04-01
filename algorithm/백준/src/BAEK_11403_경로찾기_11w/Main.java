package BAEK_11403_경로찾기_11w;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N][N];
		
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				arr[r][c] = sc.nextInt();
				
			}
		}
		
		for(int r = 0; r<N; r++) {
			visited = new boolean[N];
			find(r);
		}
		System.out.println(sb);
	}
	private static void find(int r) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(r);
		while(!q.isEmpty()) {
			int search = q.poll();
			for(int c = 0; c<N; c++) {
				if(arr[search][c] == 1 && !visited[c]) {
					q.add(c);
					visited[c] = true;
				}
			}
		}
		for(int i = 0; i<N; i++) {
			if(!visited[i]) {
				sb.append("0 ");
			}else {
				sb.append("1 ");
			}
		}
		sb.append("\n");
		
	}

}
