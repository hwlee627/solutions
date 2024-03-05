package BAEK_10816_숫자카드2_7w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arr = new int[20000001];
		for(int i = 0; i<N; i++) {
			arr[sc.nextInt()+10000000]++;
		}
		int M = sc.nextInt();
		for(int i = 1; i <= M; i++ ) {
			int num = arr[sc.nextInt()+10000000];
			sb.append(num).append(" ");
		}
		
		System.out.println(sb);
	}

}
