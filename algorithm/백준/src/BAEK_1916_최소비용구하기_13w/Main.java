package BAEK_1916_최소비용구하기_13w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
		int v, w;

		public Node(int v, int w) {
			super();
			//도착 지점
			this.v = v;
			//가중치
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
		
		
	}
	static int V, E, start, target;
	static List<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt(); //1부터 시작하네 !
		E = sc.nextInt();
		
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		list = new ArrayList[V+1];
		
		for(int i = 0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<E; i++) {
			//간선정보
			//유향
			list[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		start = sc.nextInt();
		target = sc.nextInt();
		
		
		dijkstra(start);
		
		System.out.println(dist[target]);
	}

	private static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		//시작지점 설정
		dist[st] = 0;
		
		boolean[] visited = new boolean[V+1];
		
		pq.add(new Node(st,0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.v]) {
				continue;
			}else {
				visited[curr.v] = true;
				
				for(Node n : list[curr.v]) {
					if(!visited[n.v] && dist[n.v] > dist[curr.v]+n.w) {
						dist[n.v] = dist[curr.v] + n.w;
						pq.add(new Node(n.v, dist[n.v]));
					}
				}
			}
			
		}
	}



}
