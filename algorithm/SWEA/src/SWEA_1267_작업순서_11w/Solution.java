package SWEA_1267_작업순서_11w;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int tc = 1; tc<=T; tc++) {
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			int[][] arr = new int[V+1][V+1];
			
			int[] degree = new int[V+1];
			
			for(int i = 1; i<=E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
//				System.out.println("A : " + A + " B : " + B);
				arr[A][B] = 1;
				degree[B]++;
			}
			
			StringBuilder sb = new StringBuilder();
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i = 1; i<V+1; i++) {
				if(degree[i] == 0) {
					q.add(i);
				}
			}
//			System.out.println(q);
			while(!q.isEmpty()) {
				int num = q.poll();
				sb.append(num+" ");
				for(int i = 1; i<V+1; i++) {
					if(arr[num][i] == 1) {
						degree[i]--;
						if(degree[i] == 0) {
							q.add(i);
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+sb);
		}
	}

}
