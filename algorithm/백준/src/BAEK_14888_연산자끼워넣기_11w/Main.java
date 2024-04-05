package BAEK_14888_연산자끼워넣기_11w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[] oper, tmp;
	static int[] nums;
	static int N, M, ans, min, max;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		M = N-1;
		nums = new int[N];
		
		for(int i = 0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		int[] operCnt = new int[4];
		oper = new char[M];
		visited = new boolean[M];
		//+ - * /
		
		for(int i = 0; i<4; i++) {
			operCnt[i] = sc.nextInt();
			
		}
		
		int idx = 0;
		for(int i = 0; i<4; i++) {
			if(operCnt[i] != 0) {
				if(i == 0) {
					for(int j = 0; j<operCnt[i]; j++) {
						oper[idx] = '+';
						idx++;
					}
				}else if(i == 1) {
					for(int j = 0; j<operCnt[i]; j++) {
						oper[idx] = '-';
						idx++;
					}
				}else if(i == 2) {
					for(int j = 0; j<operCnt[i]; j++) {
						oper[idx] = '*';
						idx++;
					}
				}else {
					for(int j = 0; j<operCnt[i]; j++) {
						oper[idx] = '/';
						idx++;
					}
				}
			}
		}
		tmp = new char[M];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		permutation(0);
		System.out.println(max);
		System.out.println(min);
	}
	private static void permutation(int idx) {
		
		if(idx == M) {
//			System.out.println(Arrays.toString(tmp));
			ans = nums[0];
			for(int i = 0 ; i<tmp.length; i++) {
				if(tmp[i] == '+') {
					ans = ans + nums[i+1];
				}else if(tmp[i] == '-') {
					ans = ans - nums[i+1];
				}else if(tmp[i] == '*') {
					ans = ans * nums[i+1];
				}else {
					ans = ans / nums[i+1];
				}
			}
			if(max < ans) {
				max = ans;
			}
			if(min > ans) {
				min = ans;
			}
//			System.out.println(ans);
			return;
		}
		
		for(int i = 0; i<M; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tmp[idx] = oper[i];
				permutation(idx+1);
				visited[i] =false;
			}
		}
		
	}

}
