package BAEK_15654_N과M5_11w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr, tmp;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt(); //숫자 개수
		M = sc.nextInt(); //출력해야 할 개수
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
			
		}
		Arrays.sort(arr);
		
		//순서가 다르면 다른 것으로, "순열"
		
		visited = new boolean[N+1];
		tmp = new int[M];
		permutation(0);
		System.out.println(sb);

	}
	private static void permutation(int idx) {
		if(idx == M) {
			for(int i = 0; i<M; i++) {
				if(i == (M-1)) {
					sb.append(tmp[i]+"\n");
				}else {
					sb.append(tmp[i]+" ");
				}
				
			}
			return;
		}
		
		for(int i = 1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tmp[idx] = arr[i-1];
				permutation(idx+1);
				visited[i] = false;
			}
		}
		
	}

}
