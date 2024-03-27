package BAEK_2805_나무자르기_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = 0;
		int M = 0;
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		str = br.readLine();
		st = new StringTokenizer(str);
		int[] trees = new int[N];
		int max = 0;
		int min = 0;
		while(st.hasMoreTokens()) {
			for(int i = 0; i<N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if(max < trees[i]) {
					max = trees[i];
				}
			}
		}
		//이분탐색
		while(min<max) {
			int mid = (min + max)/2;
			long sum = 0;
			for(int H : trees) {
				if(H - mid > 0) {
					sum += (H - mid);
				}
			}
			
			if(sum < M) {
				max = mid;
			}else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);


	}
}