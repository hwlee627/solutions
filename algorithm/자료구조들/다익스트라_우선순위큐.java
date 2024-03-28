import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 다익스트라_우선순위큐 {
	static class Node implements Comparable<Node>{
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
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
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		boolean[] visited = new boolean[V];
		dist[start] = 0;
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.v]) {
				continue;
			}else {
				visited[curr.v] = true;
				for(Node n : list[curr.v]) {
					if(!visited[n.v] && dist[n.v] > dist[curr.v] + n.w) {
						dist[n.v] = dist[curr.v] + n.w;
						pq.add(new Node(n.v, dist[n.v]));
					}
				}
			}
		}
	}

}
