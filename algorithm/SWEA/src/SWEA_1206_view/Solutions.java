package SWEA_1206_view;

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
			int N = sc.nextInt();
			int floor = 256;
			int result = 0;
			int[] view = new int[N];
			
			for(int i = 0; i<N; i++) {
				view[i] = sc.nextInt();
			}
			
			for(int i = 2; i<N-2; i++) {
				//기준으로 하는 좌표 주위 -2 ~ 2 범위 좌표의 높이를 체크해서 가장 높으면
				if(view[i] > view[i-2] && view[i] > view[i-1] && view[i] > view[i+1] && view[i] > view[i+2]) {
					floor = 256;
					//기준 좌표와 주위 좌표의 높이를 빼고
					//가장 작은 숫자가 조망권이 보장되는 층의 개수일 것
					for(int j = i-2; j<i+3; j++) {
						if(j == i) {
							continue;
						}else if(floor>view[i]-view[j]) {
							floor = view[i]-view[j];
						}
					}
					//result는 구한 floor의 합, 즉 문제에서 구해야 하는 결과값
					result += floor;
				}
			}
			System.out.println("#" + test_case+" "+result);
		}
	}
}
