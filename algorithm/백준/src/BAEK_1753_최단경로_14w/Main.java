package BAEK_1753_최단경로_14w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
		
		
	}
	static int V, E;
	static int[] tmp;
	static List<Node>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		int start = sc.nextInt();
		tmp = new int[V+1];
		Arrays.fill(tmp, Integer.MAX_VALUE);
		
		list = new ArrayList[V+1];
		
		for(int i = 0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		//유향
		for(int i = 0; i<E; i++) {
			list[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(start);
//		System.out.println(Arrays.toString(tmp));
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<V+1; i++) {
			if(tmp[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}else {
				sb.append(tmp[i]+"\n");
			}
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		boolean visited[] = new boolean[V+1];
		tmp[start] = 0;
		
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			
			Node curr = q.poll();
			
			if(visited[curr.v]) {
				continue;
			}else {
				visited[curr.v] = true;
				for(Node n : list[curr.v]) {
					if(!visited[n.v] && tmp[n.v] > tmp[curr.v] + n.w) {
						tmp[n.v] = tmp[curr.v] + n.w;
						q.add(new Node(n.v, tmp[n.v]));
					}
				}
			}
		}
	}

}
