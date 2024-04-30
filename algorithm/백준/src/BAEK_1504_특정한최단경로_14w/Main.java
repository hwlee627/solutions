package BAEK_1504_특정한최단경로_14w;

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
	static int V, E, must1, must2, numA, numB;
	static int[] tmp;
	static boolean[] visited;
	static boolean isPossible;
	static List<Node>[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		list = new ArrayList[V+1];
		
		for(int i = 0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<E; i++) {
			//양방향
			//노드, 노드, 가중치
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int weight = sc.nextInt();
			
			list[n1].add(new Node(n2, weight));
			list[n2].add(new Node(n1, weight));
			
		}
//		for(int i = 0; i<V+1; i++) {
//			for(int j = 0; j<list[i].size(); j++) {
//				System.out.print(list[i].get(j).v);
//			}
//			System.out.println();
//		}
		
		//꼭 들러야 하는 노드
		must1 = sc.nextInt();
		must2 = sc.nextInt();
		
//		System.out.println(must1 + " : "+must2);
		//시작 노드는 1로 고정
		
		//1에서 must1로, V에서 must2로
		//must1에서 must2로
		//1에서 must2로, V에서 must1로
		
		numA = 0;
		numB = 0;
		boolean run = true;
		boolean check = true;
		isPossible = true;
		int resultA = 0;
		int resultB = 0;
		while(run) {
			if(check) {
				numA = 0;
				dijkstra(1, must1);
				dijkstra(must1, must2);
				dijkstra(V, must2);
				resultA = numA;
				check = false;
			}else {
				numB = 0;
				dijkstra(1, must2);
				dijkstra(must1, must2);
				dijkstra(V, must1);
				resultB = numB;
				run = false;
			}

		}
		if(isPossible) {
//			System.out.println(resultA + " : " + resultB);
			if(resultA > resultB) {
				System.out.println(resultB);
			}else {
				System.out.println(resultA);
			}
		}else {
			System.out.println(-1);
		}

		
		
	}
	private static void dijkstra(int sidx, int tar) {
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		tmp = new int[V+1];
		
		Arrays.fill(tmp, Integer.MAX_VALUE);
		visited = new boolean[V+1];
		tmp[sidx] = 0;
		
		q.add(new Node (sidx, 0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			if(visited[curr.v]) {
				continue;
			}else {
				visited[curr.v] = true;
				for(Node n : list[curr.v]) {
					if(!visited[n.v] && tmp[n.v] > n.w + tmp[curr.v]) {
						tmp[n.v] = tmp[curr.v] + n.w;
						q.add(new Node(n.v, tmp[n.v]));
					}
				}

			}
		}
		if(!visited[tar]) {
			isPossible = false;
		}
		numA += tmp[tar];
		numB += tmp[tar];
//		System.out.println(Arrays.toString(visited));
	}
}
