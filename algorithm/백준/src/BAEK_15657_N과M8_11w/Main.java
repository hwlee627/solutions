package BAEK_15657_N과M8_11w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr, tmp;
//	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
			
		}
		
		Arrays.sort(arr);
//		visited = new boolean[N+1];
		tmp = new int[M];
		permutation(0,0);
		System.out.println(sb);
	}

	private static void permutation(int idx, int sidx) {
		if(idx == M) {
			for(int i = 0; i<M; i++) {
				if(i == (M-1)) {
					sb.append(tmp[i]+"\n");
				}else {
					sb.append(tmp[i] + " ");
				}
			}
			return;
		}
		
		for(int i = sidx; i<N; i++) {
			tmp[idx] = arr[i];
			permutation(idx+1, i);
		}
		
	}

}
