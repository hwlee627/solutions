package BAEK_10815_숫자카드_13w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] num = new int[20000001];
		
		for(int i = 0; i<N; i++) {
			num[sc.nextInt()+10000000]++;
		}
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<M; i++) {
			if(num[sc.nextInt()+10000000] != 0) {
				sb.append(1+" ");
			}else {
				sb.append(0+" ");
			}
		}
		System.out.println(sb);

	}

}
