package BAEK_15663_N과M9_11w;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr, tmp;
	static LinkedHashSet<String> set = new LinkedHashSet<String>();
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		tmp = new int[M];
		visited = new boolean[N+1];
		permutation(0);
		for(String str : set) {
			System.out.println(str);
		}
	}
	private static void permutation(int idx) {
		if(idx == M) {
			StringBuilder sb = new StringBuilder();
			for(int i : tmp) {
				sb.append(i+" ");
			}
			set.add(sb.toString());
			return;
		}
		
		for(int i = 1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tmp[idx] = arr[i-1];
				permutation(idx + 1);
				visited[i] = false;
			}
		}
		
	}

}
