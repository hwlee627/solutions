package BAEK_20529_가장가까운세사람의심리적거리_11w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			String[] MBTI = new String[N];
			if(N > 32) {
				System.out.println(0);
				for(int i =0; i<N; i++) {
					MBTI[i] = sc.next();
				}
				continue;
			}
			for(int i =0; i<N; i++) {
				MBTI[i] = sc.next();
			}
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i<N-2; i++) {
				for(int j = i+1; j<N-1; j++) {
					for(int k = j+1; k<N; k++ ) {
						int cnt = 0;
						for(int l = 0; l<4; l++) {
							if(MBTI[i].charAt(l) != MBTI[j].charAt(l)) {
								cnt = cnt + 1;
//								System.out.println("cnt 1 : " + cnt);
							}
							if(MBTI[i].charAt(l) != MBTI[k].charAt(l)) {
								cnt = cnt + 1;
//								System.out.println("cnt 2 : " + cnt);
							}
							if(MBTI[j].charAt(l) != MBTI[k].charAt(l)) {
								cnt = cnt + 1;
//								System.out.println("cnt 3 : " + cnt);
							}
						}
						min = Math.min(cnt, min);
						if(min == 0) {
							break;
						}
					}
				}
			}
			
			System.out.println(min);
			
			
			
			
		}

	}

}
