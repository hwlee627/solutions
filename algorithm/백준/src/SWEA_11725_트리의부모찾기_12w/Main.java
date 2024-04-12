package SWEA_11725_트리의부모찾기_12w;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
		static class Node{
			int value, parent;

			public Node(int value, int parent) {
				this.value = value;
				this.parent = parent;
			}
			
			
		}
	static LinkedList<Integer>[] list;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //노드의 개수
		
		list = new LinkedList[N+1];
		for(int i = 0; i<N+1; i++) {
			list[i] = new LinkedList();
		}
		for(int i = 1; i<N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		
		}
//		for(int i = 0; i<N+1; i++ ) {
//			System.out.println(Arrays.toString(adj[i]));
//		}
		boolean[] visited = new boolean[N+1];
		
		Queue<Node> q = new LinkedList<>();
		Node n = new Node(1,1);
		int [] parents = new int[N+1];
		visited[1] = true;
		q.add(n);
//		for(int i = 0; i<N+1; i++) {
//			System.out.println(list[i].size());
//		}
		while(!q.isEmpty()) {
			
			int value = q.poll().value;
			
			for(int i = 0; i<list[value].size(); i++) {
				if(!visited[list[value].get(i)]) {
					Node node = new Node(list[value].get(i),value);
					visited[node.value] = true;
					parents[node.value] = value;
					q.add(node);
				}

			}
		}
//		System.out.println(Arrays.toString(parents));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 2; i<N+1; i++) {
			sb.append(parents[i]+"\n");
		}
		System.out.println(sb);
	}	  

}
