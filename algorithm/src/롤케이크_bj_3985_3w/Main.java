package 롤케이크_bj_3985_3w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		int[] cake = new int[length];
		int peoCnt = sc.nextInt();
		//방청객이 번호를 적음으로서 기대했던 케잌 조각의 수를 담을 배열
		int[] expect = new int[peoCnt];
		//방청객이 실제로 받게 된 케잌 조각의 수를 담을 배열
		int[] actual = new int[peoCnt];
		
		
		for(int i = 1; i<=peoCnt; i++) {
			//방청객이 적은 숫자가 2와 4 라면
			//실제 cake배열의 인덱스는
			//1부터 3임
			int start = sc.nextInt()-1;
			int end = sc.nextInt()-1;
			//번호가 앞선 방청객 번호부터 적으므로 
			//인덱스의 값이 '0'일 때만 본인의 번호를 적게 함
			for(int j = start; j<=end; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
				}
				
			}
			// 방청객이 예상한 개수를 담음
			expect[i-1] = end - start + 1;
		}
//		System.out.println(Arrays.toString(cake));
		//cake배열을 순회 돌려서
		//방청객이 적은 번호의 숫자를 세면
		//그 방청객이 실제로 받은 케잌의 개수를 알 수 있음
		for(int i = 0; i<cake.length; i++) {
			if(cake[i] != 0) {
				actual[cake[i]-1]++;
			}
		}
		int expectMax = 0;
		int actualMax = 0;
		
		//각각의 최대값을 구해서
		for(int i = 0; i<peoCnt; i++) {
			if(expect[i]>expectMax) {
				expectMax = expect[i];
			}
			if(actual[i]>actualMax) {
				actualMax = actual[i];
			}
		}
		
		//그 최대값의 인덱스가 뭔지 찾아내고 프린트
		//중복값이 있을 때는 둘다 출력하기 때문에
		//작은 번호의 방청객을 출력하기 위해
		//한번 출력하면 break를 걸어서 종료되게 만듬
			for(int i = 0; i<peoCnt; i++) {
				if(expect[i] == expectMax) {
					System.out.println(i+1);
					break;
				}
			}
			for(int i = 0; i<peoCnt; i++) {
				if(actual[i] == actualMax) {
					System.out.println(i+1);
					break;
				}
			}
		
		

	}

}
