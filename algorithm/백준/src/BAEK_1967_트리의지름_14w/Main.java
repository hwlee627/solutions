package BAEK_1967_트리의지름_14w;

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
	static int V, E, length;
	static List<Node>[] list;
	static int[] tmp, max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = V-1; 
		
		list = new ArrayList[V+1];
		
		for(int i = 0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int maxS1 = 0;
		for(int i = 0; i<E; i++) {
			int s1 = sc.nextInt();
			int s2 = sc.nextInt();
			int s3 = sc.nextInt();
			if(maxS1 < s1) {
				maxS1 = s1;
			}
			list[s1].add(new Node(s2, s3));
			list[s2].add(new Node(s1, s3));
		}
		
//		for(int i = 0; i<V; i++) {
//			if(list[i] != null) {
//				for(int j = 0; j<list[i].size(); j++) {
//					System.out.print(list[i].get(j).v);
//				}
//			}
//
//			System.out.println();
//		}
//		System.out.println(maxS1);
		length = 0;
		for(int i = maxS1+1; i<=V; i++) {
			tmp = new int[V+1];
			Arrays.fill(tmp, Integer.MAX_VALUE);
			dijkstra(i);
		}
		
		System.out.println(length);
	}
	private static void dijkstra(int sidx) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		tmp[sidx] = 0;
		
		q.add(new Node(sidx, 0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			if(visited[curr.v]) {
				continue;
			}else {
				visited[curr.v] = true;
				if(list[curr.v] != null) {
					for(Node n : list[curr.v]) {
						if(!visited[n.v] && tmp[n.v] > n.w + tmp[curr.v]) {
							tmp[n.v] = n.w + tmp[curr.v];
							q.add(new Node(n.v, tmp[n.v]));
						}
					}
				}

			}
		}
		for(int i = 1; i<=V; i++) {
			if(tmp[i] > length) {
				length = tmp[i];
			}
		}
		
	}

}
