package BAEK_1003_피보나치함수_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		// 1 0    0
		// 0 1    1
		// 1 1    2
		// 1 2    3
		// 2 3    4
		// 3 5    5
		List<Integer> zeroList = new ArrayList<>();
		List<Integer> oneList = new ArrayList<>();
		
		zeroList.add(1); //index 0
		oneList.add(0); 
		zeroList.add(0); //index 1
		oneList.add(1);
		for(int i = 2; i<=40; i++ ) {
			oneList.add(zeroList.get(i-1)+oneList.get(i-1));
			zeroList.add(oneList.get(i-1));
		}
//		for(int num : zeroList) {
//			System.out.print(num+" ");
//		}
		for(int i = 0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(zeroList.get(N)+" "+oneList.get(N)+"\n");
		}
		System.out.println(sb);

	}

}
