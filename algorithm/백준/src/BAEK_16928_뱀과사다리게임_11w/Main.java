package BAEK_16928_뱀과사다리게임_11w;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
		int value, level;

		public Node(int value, int level) {
			this.value = value;
			this.level = level;
		}

		@Override
		public int compareTo(Node o) {
			if(this.level == o.level) {
				return Integer.compare(this.value, o.value);
			}
			return Integer.compare(this.level, o.level);
			
		}
		
	}
	static int[][] arr;
	static boolean[] visited;
	static int minNum;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int S = sc.nextInt();
		
		arr = new int[101][101];

		for(int i = 1; i<=L; i++) {
			int start = sc.nextInt();
			int desti = sc.nextInt();
			arr[start][desti] = 3;
		}
		for(int i = 1; i<=S; i++) {
			int start = sc.nextInt();
			int desti = sc.nextInt();
			arr[start][desti] = 2;
		}
		
		for(int i = 1; i<=99; i++) {
			boolean check = false;
			for(int j = 1; j<=100; j++) {
				if(arr[i][j] == 2 || arr[i][j] == 3) {
					check = true;
				}
			}
			if(!check) {
				for(int j = i+1; j <= i+6; j++) {
					if(j<=100) {
						arr[i][j] = 1;
					}
				}
			}

		}
		//인접 행렬 완료
		visited = new boolean[101];
		visited[0] = true;
		visited[1] = true;
		
		Node node = new Node(1,0);
		minNum = Integer.MAX_VALUE;
		
		pq.add(node);
		find();
		System.out.println(minNum);
	}

	private static void find() {
		while(!pq.isEmpty()) {
			Node node = pq.poll();
//			System.out.println(node.value);
			if(node.value == 100) {
//				System.out.println(node.level);
				if(minNum > node.level) {
					minNum = node.level;
				}
				
			}
			for(int r = 1; r<=100; r++) {
				if(arr[node.value][r] == 1 && !visited[r]) {
					Node tar = new Node(r, node.level+1);
					visited[r] = true;
					pq.add(tar);
				}else if(arr[node.value][r] == 2) {
					Node tar = new Node(r, node.level);
					visited[r] = true;
					pq.add(tar);
				}else if(arr[node.value][r] == 3) {
					Node tar = new Node(r, node.level);
					visited[r] = true;
					pq.add(tar);
				}
			}
		}

	}

}
