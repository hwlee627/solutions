package BAEK_6603_로또_14w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, R;
	static int[] tmp, nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			N = sc.nextInt();
			if(N == 0) {
				break;
			}else {
				R = 6;
				tmp = new int[R];
				nums = new int[N];
				for(int i = 0; i<N; i++) {
					nums[i] = sc.nextInt();
				}
				combination(0,0);
				System.out.println();
			}
		}

	}
	private static void combination(int sidx, int idx) {
		if(idx == R) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<R; i++) {
				sb.append(tmp[i]+" ");
			}
			System.out.println(sb);
			return;
		}
		
		for(int i = sidx; i<N; i++) {
			tmp[idx] = nums[i];
			combination(i+1, idx+1);
		}
	}

}
