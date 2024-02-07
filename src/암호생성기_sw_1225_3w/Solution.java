package 암호생성기_sw_1225_3w;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int text = sc.nextInt();
			int [] nums = new int [8];
			
			for(int i = 0; i<8; i++) {
				nums[i] = sc.nextInt();
			}
			
			int minusCnt = 1;
			boolean run = true;
			
			while(run) {
				//minusCnt는 1, 2, 3, 4, 5가 있으므로
				//나머지 연산을 통해 계속 반복할 수 있음
				if(minusCnt % 6 != 0) {
					//nums배열 안의 값을 minusCnt로 뺐을 때
					//음수이거나 0이라면 0으로 값을 고정하고
					//맨 마지막 인덱스로 보낸 후
					//사이클 종료
					if(nums[0] - minusCnt <= 0) {
						nums[0] = 0;
						run = false;
					}else {
						nums[0] -= minusCnt;
					}
					
					//뺀 값을 임시 정수변수에 저장하고
					int tmp = nums[0];
					//나머지 배열의 자료값의 인덱스를 하나씩 왼쪽으로(1 작은 번호로)옮기고
					for(int i = 0; i<=6; i++) {
						nums[i] = nums[i+1];
					}
					//마지막 인덱스에 임시 변수 tmp에 담아놨던 값 입력
					nums[7] = tmp;
					//끝낸 후 minusCnt 값 1추가
					minusCnt++;
					
				}else {
					//minusCnt가 6일때 들어오게 되는데
					//minusCnt를 1로 초기화
					minusCnt = 1;
				}
				
			}
			System.out.print("#"+test_case);
			for(int i = 0; i<8; i++) {
				System.out.print(" "+nums[i]);
			}
			System.out.println();
		}
	}
}
