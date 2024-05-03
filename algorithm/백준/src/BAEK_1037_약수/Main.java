package BAEK_1037_약수;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		if(N == 1) {
			int num = sc.nextInt();
			System.out.println(num*num);
		}else {
			int[] arr = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.println(arr[0] * arr[N-1]);
		}

	}

}
