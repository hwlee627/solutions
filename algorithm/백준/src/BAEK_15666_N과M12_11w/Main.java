package BAEK_15666_N과M12_11w;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr, tmp;
	static LinkedHashSet<String> set = new LinkedHashSet<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
			
		}
		
		tmp = new int[M];
		Arrays.sort(arr);
		combination(0, 0);
		
		for(String str : set) {
			System.out.println(str);
		}
	}
	private static void combination(int idx, int sidx) {
		
		if(idx == M) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<M; i++) {
				sb.append(tmp[i] + " ");
			}
			set.add(sb.toString());
			return;
		}
		
		for(int i = sidx; i<N; i++) {
			tmp[idx] = arr[i];
			combination(idx+1, i);
		}
	}

}
