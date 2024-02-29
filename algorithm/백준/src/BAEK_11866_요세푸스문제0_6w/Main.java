package BAEK_11866_요세푸스문제0_6w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//사람 수
		int N = sc.nextInt();
		//K번째 사람 제거
		int K = sc.nextInt();
		
		int[] people = new int[N];
		
		//배열의 값이 0이면 아직 사망하지 않음
		//1이면 사망상태이며, 사망상태로 된 인덱스 값+1을 order 배열에 담을 것
		
		int[] order = new int[N];
		//order배열에서, 0번인덱스는 가장 먼저 죽은 사람의 인덱스 번호
		//N-1번 인덱스는 가장 나중에 죽은 사람의 인덱스 번호
		int orderIndex = 0;
		//jump = k가 되면 그 때 사망처리 및 jump = 0 으로 초기화
		int jump = K;
		//죽은 사람의 수를 세서, 그 숫자가 사람수와 동일해지면 break;
		int deathCnt = 0;
		//주어진 K값 번째의 사람이 먼저 죽고 시작하므로
		//i의 시작점은 K-1;
		for(int i = K-1; i<=N; i++) {
			if(i == N) {
				i = 0;
			}
			if(people[i] == 0) {
				if(jump == K) {
					jump = 1;
					people[i] = 1;
					order[orderIndex] = i;
					orderIndex++;
				}else {
					jump++;
				}
			}
			if(orderIndex == N) {
				break;
			}
			
			
		}
		System.out.print("<");
		for(int i = 0; i<order.length; i++) {
			
			if(i == order.length-1) {
				System.out.printf("%d",order[i]+1);
			}else {
				System.out.printf("%d, ",order[i]+1);
			}
		}
		System.out.println(">");
		
	}

}
