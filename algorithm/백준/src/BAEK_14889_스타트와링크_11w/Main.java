package BAEK_14889_스타트와링크_11w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[][] power;
	static int[] per, tmp1, tmp2;
	static boolean[] visited;
	static int N, sum1, sum2, minus, min;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		power = new int [N][N];
		
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				power[i][j] = sc.nextInt();
				
			}
		}
		
		per = new int[N];
		for(int i = 0; i<N; i++) {
			per[i] = i;
		}
		tmp1 = new int[N/2];
		tmp2 = new int[N/2];
		min = Integer.MAX_VALUE;
		
		combination(0,0);
		System.out.println(min);
	}
	private static void combination(int idx, int sidx) {
		
		if(idx == N/2) {
//			System.out.println("tmp1 : "+Arrays.toString(tmp1));
			
			int index = 0;
			visited = new boolean[N];
			sum1 = 0;
			sum2 = 0;
			for(int i = 0; i<N/2; i++) {
				visited[tmp1[i]] = true;
			}
			for(int i = 0; i<N/2; i++) {
				for(int j = 0; j<N/2; j++) {
					if(j != i) {
						sum1 += power[tmp1[i]][tmp1[j]] + power[tmp1[j]][tmp1[i]];
					}
				}
			}
			
			
			for(int i = 0; i<N; i++) {
				if(!visited[i]) {
					tmp2[index] = i;
					index++;
				}
			}
			for(int i = 0; i<N/2; i++) {
				for(int j = 0; j<N/2; j++) {
					if(j != i) {
						sum2 += power[tmp2[i]][tmp2[j]] + power[tmp2[j]][tmp2[i]];
					}
				}
			}
//			System.out.println(Arrays.toString(tmp1)+" sum 1 : "+sum1);
//			System.out.println(Arrays.toString(tmp2)+" sum 2 : "+sum2);
			minus = Math.abs(sum1/2-sum2/2);
			if(min > minus) {
				min = minus;
			}
//			System.out.println("tmp2 : "+Arrays.toString(tmp2));
			return;
		}
		
		for(int i = sidx; i<N; i++) {
			tmp1[idx] = per[i];
			combination(idx + 1, i + 1);
		}
		
	}
}