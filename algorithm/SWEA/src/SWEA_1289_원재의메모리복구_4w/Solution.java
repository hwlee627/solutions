package SWEA_1289_원재의메모리복구_4w;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String memory = sc.next();

			//숫자가 몇번 바뀌는지만 세면 됨
			//초기 상태는 0이므로 첫번째 1이 어디있나 확인
			int idx = 0;
			int cnt = 0;
			for(int i = 0; i < memory.length(); i++) {
				//첫번째 1을 찾고 그 인덱스를 저장
				if(memory.charAt(i) == '1') {
					idx = i;
					//기본상태인 0 에서 1로 한번 바뀐것이므로
					//횟수를 추가해주었음
					cnt++;
					break;
				}
			}
			//처음 1이 나오는 위치부터 숫자가 몇번 바뀌는지 체크
			for(int i = idx; i<memory.length(); i++) {
				if(i+1 < memory.length()) {
					if(memory.charAt(i) != memory.charAt(i+1)) {
						cnt++;
					}
				}
				
			}
			System.out.println("#"+test_case+" "+cnt);
		}
	}
}
