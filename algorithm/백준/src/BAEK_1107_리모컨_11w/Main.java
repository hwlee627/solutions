package BAEK_1107_리모컨_11w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, min, tar;
	static String minNum;
	static boolean[] visited, broken;
	static int[] nums, tmp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		broken = new boolean[10];
		
		String target = sc.next();
		int length = target.length();	
		tar = Integer.parseInt(target);
//		System.out.println("tar : " + tar);
		int B = sc.nextInt();
		if(tar == 100) {
			System.out.println(0);
		}else if(B == 0){
			int dept = Math.abs(100 - tar);
			if(dept >= length) {
				System.out.println(length);
			}else {
				System.out.println(dept);
			}
			
		}else if(B == 10) {
			for(int i = 0; i<B; i++) {
				broken[sc.nextInt()] = true;
			}
			System.out.println(Math.abs(100-tar));
		}else {
			if(Math.abs(tar-100) <3) {
				for(int i = 0; i<B; i++) {
					broken[sc.nextInt()] = true;
				}
				System.out.println(Math.abs(tar-100));
			}else {
				N = 10-B;
				for(int i = 0; i<B; i++) {
					broken[sc.nextInt()] = true;
				}
				nums = new int[N];
				int idx = 0;
				for(int i = 0; i<10; i++) {
					if(!broken[i]) {
						nums[idx] = i;	
						idx++;
					}
				}
//				System.out.println(Arrays.toString(nums));
				min = Integer.MAX_VALUE;
				for(int i = length-1; i<=length+1; i++) {
					if(i > 0 || i <=6) {
							M = i;
							if(M>0) {
//								System.out.println("M : "+ M);
								tmp = new int[M];
								permutation(0);
						}
							}
							
				}
				System.out.println(min);
			}
			
		}
		
		
	}

	private static void permutation(int idx) {
		if( idx == M && M>0) {
//			System.out.println(Arrays.toString(tmp));
			String str = "";
			for(int i = 0; i<tmp.length; i++) {
				str += tmp[i]+"";
			}
			int num = Integer.parseInt(str);
			int minus = Math.abs(num-tar);
			int result = minus + str.length();
			int hundred = Math.abs(100-tar);
			if(min > result) {
				min = result;
			}
			if(min > hundred) {
				min = hundred;
			}
			
			return;
			
		}
		for(int i = 0; i<N; i++) {
			tmp[idx] = nums[i];
			permutation(idx+1);
		}
		
		
	}

}
