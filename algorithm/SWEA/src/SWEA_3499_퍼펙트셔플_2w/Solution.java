package SWEA_3499_퍼펙트셔플_2w;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
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
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			sc.nextLine();
			int num = 0;
			String str = sc.nextLine();
			
			String[] words = new String[N];
			int div = N/2;
			int div2 = N-div;
			//div와 div2는 짝수일 땐 같고
			//홀수일 땐 div2가 앞 배열이 될 예정
			String[] card1 = new String[div2];
			String[] card2 = new String[div];
			//공백을 기준으로 단어를 받아준다
			StringTokenizer st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				words[num] =  st.nextToken();
				num++;
			}
			int index = 0;
			for(int i = 0; i<N; i++) {
				if(i<div2) {
					card1[i] = words[i];
				}else {
					card2[index] = words[i];
					index++;
				}
			}
			//인덱스용 정수 변수
			int card1Cnt = 0;
			int card2Cnt = 0;
			
			for(int i = 0; i<N; i++) {
				if(i % 2 == 0) {
					words[i] = card1[card1Cnt];
					card1Cnt++;
				}else {
					words[i] = card2[card2Cnt];
					card2Cnt++;
				}
			}
			System.out.printf("#%d ",test_case);
			for(int i = 0; i<N; i++) {
				if(i == N-1) {
					System.out.printf("%s\n",words[i]);
				}else {
					System.out.printf("%s ",words[i]);
				}
			}
		}
	}
}
