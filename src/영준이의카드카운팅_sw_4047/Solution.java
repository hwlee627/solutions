package 영준이의카드카운팅_sw_4047;

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
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			//카드는 01 ~ 13 
			//S D H C
			
			//count 배열 생성
			int[] S = {0,1,1,1,1,1,1,1,1,1,1,1,1,1};
			int[] D = {0,1,1,1,1,1,1,1,1,1,1,1,1,1};
			int[] H = {0,1,1,1,1,1,1,1,1,1,1,1,1,1};
			int[] C = {0,1,1,1,1,1,1,1,1,1,1,1,1,1};
			
			int Scnt = 0;
			int Dcnt = 0;
			int Hcnt = 0;
			int Ccnt = 0;
			boolean pass = true;
			String cards = sc.next();
			String[] cardsArr = String.valueOf(cards).split("");
			
			for(int i = 0; i<cards.length(); i+=3) {
				if(cardsArr[i].equals("S")) {
					S[Integer.parseInt(cardsArr[i+1]+cardsArr[i+2])]--;
				}else if(cardsArr[i].equals("D")) {
					D[Integer.parseInt(cardsArr[i+1]+cardsArr[i+2])]--;
				}else if(cardsArr[i].equals("H")) {
					H[Integer.parseInt(cardsArr[i+1]+cardsArr[i+2])]--;
				}else if(cardsArr[i].equals("C")) {
					C[Integer.parseInt(cardsArr[i+1]+cardsArr[i+2])]--;
				}
			}
			for(int i = 0; i<S.length; i++) {
				if(S[i] <= -1) {
					pass = false;
				}else if(D[i] <= -1) {
					pass = false;
				}else if(H[i] <= -1) {
					pass = false;
				}else if(C[i] <= -1) {
					pass = false;
				}else {
					Scnt += S[i];
					Dcnt += D[i];
					Hcnt += H[i];
					Ccnt += C[i];
				}
			}
//			System.out.println(Arrays.toString(S));
//			System.out.println(Arrays.toString(D));
//			System.out.println(Arrays.toString(H));
//			System.out.println(Arrays.toString(C));
			if(pass) {
				System.out.println("#"+test_case+" "+Scnt+" "+Dcnt+" "+Hcnt+" "+Ccnt);
			}else {
				System.out.println("#"+test_case+" ERROR");
			}
			
			
		}
	}
}