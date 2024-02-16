package 소인수분해_bj_11653_4w;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 에라토스테네스의 체 사용
		// 범위는 1000000까지임
		boolean[] prime = new boolean[10000001];
		// 소수 = false 소수 아니면 true
		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i < Math.sqrt(10000000); i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= 10000000; j += i) {
					prime[j] = true;
				}
			}
		}
		//10,000,000까지의 소수를 담음
		List<Integer> primeList = new ArrayList<Integer>();
		
		for (int i = 0; i < prime.length; i++) {
			if (!prime[i]) {
				primeList.add(i);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		//소수 리스트에 num이 담겨있을 경우 비교 후
		if(primeList.contains(num)) {
			System.out.println(num);
			//담겨있지 않을 경우
		}else {
			while(true) {
				for(int primeNum : primeList) {
					if(num == 1) {
						break; //N이 1일 경우에는 아무것도 출력하지 않기 + for문 빠져나오기
					}
					if(num%primeNum == 0) {
						num /= primeNum;
						System.out.println(primeNum);
						cnt++;
						break; //이 브레이크를 안 걸면 72 -> 22233 이 아닌 23232가 나와버림
					}
				}
				if(num == 1) { 
					break; //while문 빠져나오기
				}
			}
			
		}
		
	}

}
