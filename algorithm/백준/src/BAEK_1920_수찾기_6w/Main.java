package BAEK_1920_수찾기_6w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int key;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Integer> setN = new HashSet<Integer>();
		List<Integer> listM = new ArrayList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		String str2 = br.readLine();
		st = new StringTokenizer(str2);
		
		for(int i = 0; i<M; i++) {
			key = Integer.parseInt(st.nextToken());
			if(binarySearch(arr, key)) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
//		StringTokenizer st = new StringTokenizer(str);
//		
//		for(int i = 0; i<N; i++) {
//			setN.add(Integer.parseInt(st.nextToken()));
//		}
//		
//
//		int M = Integer.parseInt(br.readLine());
//		
//		String str2 = br.readLine();
//		st = new StringTokenizer(str2);
//		
//		for(int i = 0; i<M; i++) {
//			int num = Integer.parseInt(st.nextToken());
//			boolean check = false;
//			for(int numN : setN) {
//				if(num == numN) {
//					check = true;
//					sb.append(1).append("\n");
//				}
//			}
//			if(!check) {
//				sb.append(0).append("\n");
//			}
//			
//		}
		System.out.println(sb);
	}
	
	static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == key)
				return true;
			else if (arr[mid] > key)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return false;
	}

}
