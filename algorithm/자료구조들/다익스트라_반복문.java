import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다익스트라_반복문 {
	static class Node{
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
	}
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		list = new ArrayList[V];
		for(int i = 0; i<V; i++) {
			list[i] = new ArrayList<>();
		}
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		
		for(int i = 0; i<E; i++) {
			//이번엔 유향이니까
			//시작정점, 도착정점, 가중치 순으로 입력이 들어온다
			list[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(0); //0번정점부터 알고리즘 슈웃
		System.out.println(Arrays.toString(dist));
	}

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[V];
		
		dist[start] = 0;
		
		//인접 찾자
		
		//모든 정점을 다 돌 때 까지 해보려고.. (도착이 주어지면 거기 방문하면 멈추는 조건문 넣으면 됨)
		for(int i = 0; i<V-1; i++) {
			int min = INF;
			int idx = -1;
			
			for(int j = 0; j<V; j++) {
				if(!visited[j] && min>dist[j]) {
					min = dist[j];
					idx = j;
				}
			}//idx : 방문하지 않았으면서, 시작 정점에서 해당 idx정점까지의 거리가 최소인 녀석
			
			if(idx == -1) break; //내가 갈수있는 곳이 없다 !
			
			visited[idx] = true; //방문 했다 !
			for(Node node : list[idx]) {
				if(!visited[node.v] && dist[node.v] > dist[idx]+node.w) {
					dist[node.v] = dist[idx] + node.w;
				}
			}
		}
		
	}

}
