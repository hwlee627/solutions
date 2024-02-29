package 최대성적표만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int[] scores;
	static int N, R, max;
	static int[] tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			max = 0;
			String nums = br.readLine();
			StringTokenizer st = new StringTokenizer(nums);
			for(int i = 0; i<2; i++) {
				if(i == 0) {
					N = Integer.parseInt(st.nextToken());
				}else {
					R = Integer.parseInt(st.nextToken());
				}
			}
			
			scores = new int[N];
			String score = br.readLine();
			
			st = new StringTokenizer(score);
			for(int i = 0; i<N; i++) {
				
				scores[i] = Integer.parseInt(st.nextToken());
			}
			
			
			tmp = new int[R];
			combination(0, 0);
			
			System.out.println("#"+tc+" "+max);
		}

	}
	private static void combination(int idx, int sidx) {
		if(sidx == R) {
			int sum = 0;
//			System.out.println(Arrays.toString(tmp));
			for(int i = 0; i<R; i++) {
				sum += tmp[i];
			}
			if(max < sum) {
				max = sum;
			}
			return;
		}
		
		for(int i = idx; i<=N-R+sidx; i++) {
			tmp[sidx] = scores[i];
			combination(i+1, sidx+1);
		}
		
	}

}
