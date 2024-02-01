package 영식이와친구들_bj_1592_2w;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//사람 수
		int N = sc.nextInt();
		//목표 횟수
		int M = sc.nextInt();
		//던지는 칸 수
		int L = sc.nextInt();
		
		int cnt = 0;
		//처음 받는 사람의 인덱스는 0 이므로
		int person = 0;
		
		int[] count = new int [N];
		
		count[0] = 1;
		
		while(count[person] != M) {
			if(count[person] % 2 == 1) {
				if(person+L > N-1) {
					person = person+L-N;
					count[person]++;
					cnt++;
				}else {
					person += L;
					count[person]++;
					cnt++;
				}
			}else {
				if(person-L < 0) {
					person = person-L+N;
					count[person]++;
					cnt++;
				}else {
					person -= L;
					count[person]++;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		

	}

}
