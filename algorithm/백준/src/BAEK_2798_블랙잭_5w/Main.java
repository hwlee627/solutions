package BAEK_2798_블랙잭_5w;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum = sc.nextInt();
		
		int[] cards = new int[N];
		for(int i = 0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		int max = 0;
		for(int i = 0; i<N; i++) {
			for(int j = i+1; j<N; j++) {
				for(int k = j+1; k<N; k++) {
					if(cards[i]+cards[j]+cards[k]<=sum) {
						if(max<cards[i]+cards[j]+cards[k]) {
							max = cards[i]+cards[j]+cards[k];
						}
					}
				}
			}
		}
		System.out.println(max);
		
	}

}
