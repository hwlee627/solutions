package BAEK_11726_2xn타일링_9w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long[] cnt = new long[1001];
		
		cnt[0] = 0;
		cnt[1] = 1;
		cnt[2] = 2;
		for(int i = 3; i<1001; i++) {
			cnt[i] = cnt[i-2]+cnt[i-1];
			cnt[i] = cnt[i]%10007;
		}
		
		int N = sc.nextInt();
		
		System.out.println(cnt[N]);

	}

}
