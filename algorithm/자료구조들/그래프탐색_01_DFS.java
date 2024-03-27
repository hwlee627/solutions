import java.util.Arrays;
import java.util.Scanner;

public class 그래프탐색_01_DFS {
	static int N;
	static int[][] adj;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int T = sc.nextInt();
		adj = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i = 0; i<T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adj[A][B] = 1;
			adj[B][A] = 1;
		
			
			
		}
		for(int[] arr : adj) {
			System.out.println(Arrays.toString(arr));
		}
		
		DFS(2);
		
	}

	private static void DFS(int start) {
		//start 노드 방문 처리
		visited[start] = true;
		System.out.println(start);
		
		//인접한 노드 방문
		for(int i = 1; i<=N; i++) {
			if(!visited[i] && adj[start][i] == 1) {
				DFS(i);
			}
		}
		
	}

}
