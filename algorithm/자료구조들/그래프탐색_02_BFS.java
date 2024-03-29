import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 그래프탐색_02_BFS {
	static int N;
	static List<Integer>[] adj;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int T = sc.nextInt();
		adj = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i = 1; i<=N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i<T; i++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adj[A].add(B);
			adj[B].add(A);
		}
		for(List list : adj) {
			System.out.println(list);
		}
		BFSlist(1);
		
		
	}

	private static void BFSlist(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(v);
		visited[v] = true;
		
		//큐가 공백이 될 때 까지 수행
		while(!q.isEmpty()) {
			int curr = q.poll(); //하나 꺼내 !
			System.out.println(curr); //경로 보기
			
			//인접 리스트
			for(int i :adj[curr]) {
				if(!visited[i]) {
					q.add(i);
					visited[i] = true; //넣을 때 true
				}
			}
		}
		
	}
	private static void BFSarr(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(v);
		visited[v] = true;
		
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

}
