package SWEA_1208_Flatten;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
	class Solution
	{
		public static void main(String args[]) throws Exception
		{
			/*
			   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
			   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
			   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
			   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
			   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
			 */
			//System.setIn(new FileInputStream("res/input.txt"));
	
			/*
			   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
			 */
			Scanner sc = new Scanner(System.in);
			int T = 10;
			
			/*
			   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
			*/
	
			for(int test_case = 1; test_case <= T; test_case++)
			{
				int dumpCnt = sc.nextInt();
				int [] boxes = new int[100];
				//박스 높이 배열 생성
				for(int i = 0; i < 100; i++) {
					boxes[i] = sc.nextInt();
				}
				
				
				//시행횟수
				int cnt = 0;
				//최종 상태의 최고높이와 최저높이를 뺀 값
				int result = 0;
				//주어진 덤프수와 지금까지 시행한 횟수가 같아지면
				//그 때의 최고 높이와 최저 높이를 측정해야 하기때문에
				//while문의 조건이 cnt < dumpCnt+1 임
				while(cnt <dumpCnt+1) {
					//최대 높이 최소 높이 변수 생성
					//박스 높이는 1 ~ 100 사이
					int maxHeight = 0;
					int maxIndex = 0;
					int minHeight = 101;
					int minIndex = 0;
					
					//최고 높이와 최저 높이의 인덱스 번호를 받음
					for(int i = 0; i<boxes.length; i++) {
						if(boxes[i] > maxHeight) {
							maxHeight = boxes[i];
							maxIndex = i;
						}
						if(boxes[i] < minHeight) {
							minHeight = boxes[i];
							minIndex = i;
						}
					}
					//덤프 횟수를 모두 사용하지 않더라도 밑과 같이
					//1. 최대높이와 최소높이의 차이가 1인 경우와
					//2. 최대높이와 최소높이가 같아질 경우
					//덤프를 그만해야 함
					if(maxHeight == minHeight){
						result = 0;
						break;
					//위의 경우가 아니라면
					//찾은 인덱스 번호의 최대값에는 -1, 최솟값에는 +1을 해주고
					//시행 횟수 +1을 하며 마무리
					}else {
	
						boxes[minIndex] += 1;
						boxes[maxIndex] -= 1;
						++cnt;
					}
					//시행횟수가 입력받은 덤프횟수와 같아질 때(덤프 횟수만큼 모두 시행했을 때)
					//그 상태의 최대 최소 높이를 구해서 뺀 값을 출력해야함
					//시행 후 cnt++을 해줬으므로, 덤프 횟수 +1과 같을 경우임
					if(cnt == dumpCnt+1) {
						for(int i = 0; i<boxes.length; i++) {
							if(boxes[i] > maxHeight) {
								maxHeight = boxes[i];
							}
							if(boxes[i] < minHeight) {
								minHeight = boxes[i];
							}
						}
						result = maxHeight - minHeight;
					}
						
					
				}
				System.out.println("#"+test_case+" "+result);
			}
		}
	}
