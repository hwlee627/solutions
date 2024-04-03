package BAEK_15652_N과M4_11w;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr, tmp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for(int i = 1; i<=N; i++) {
			arr[i-1] = i;
		}
		tmp = new int[M];
		
		combination(0,0);
		System.out.println(sb);
	}
	private static void combination(int idx, int sidx) {
		if(idx == M) {
			for(int i = 0 ; i<M; i++) {
				if(i == (M-1)) {
					sb.append(tmp[i]+"\n");
				}else {
					sb.append(tmp[i]+" ");
				}
				
			}
			return;
		}
		
		for(int i = sidx; i<N; i++) {
			tmp[idx] = arr[i];
			combination(idx+1, i);
		}
		
	}

}
