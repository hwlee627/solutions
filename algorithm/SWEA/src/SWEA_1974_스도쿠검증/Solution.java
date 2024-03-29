/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
package SWEA_1974_스도쿠검증;

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
		
			int[][] sudoku = new int [9][9];
			for(int r = 0; r<9; r++) {
				for(int c = 0; c<9; c++) {
					sudoku[r][c] = sc.nextInt();
				}
			}
			boolean find = false;
			//스도쿠 판별조건
			//1. 3x3 9칸 내 숫자 겹치지 않기
			//2. 가로줄 9칸 내 숫자 겹치지 않기
			//3. 세로줄 9칸 내 숫자 겹치지 않기
			
			//count 배열 만들기
			//숫자번째 인덱스를 ++ 시킨 후 인덱스 번호 0을 제외한 요소에 2가 있으면 겹치는 숫자가 있는 것
			int[] count = new int[10];
			
			//1. 3x3 9칸 내 숫자 겹치는지 판별
			//8방 탐색 배열 생성
			int[] dr = {-1,1,0,0,-1,1,-1,1};
			int[] dc = {0,0,-1,1,-1,-1,1,1};//상하좌우 좌상좌하우상우하
			
			//특정 좌표에서만 8방탐색을 하면 됨.
			//(1,1)(1,4)(1,7)
			//(4,1)(4,4)(4,7)
			//(7,1)(7,4)(7,7)
			
			for(int r=1; r<9; r+=3) {
				for(int c=1; c<9; c+=3) {
					//8방탐색한 결과를 count 배열에 넣으면 됨
					for(int i = 0; i<10; i++) {
						count[i] = 0;
					}
					count[sudoku[r][c]]++;
					for(int d = 0; d<8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						count[sudoku[nr][nc]]++;
					}
					for(int i =1; i<10; i++) {
						if(count[i]!=1) {
							find=true;
						}
					}
				}
			}
			//2. 가로줄 9칸 내 숫자 겹치는지 판별
			//가로 좌표는 0으로 고정, 세로 좌표만 움직임
			
			for(int r=0; r<9; r++) {
				for(int i = 0; i<10; i++) {
					count[i] = 0;
				}
				for(int l=0; l<=8;l++) {
					int nc= l;
					count[sudoku[r][nc]]++;
				}
				for(int i =1; i<10; i++) {
					if(count[i]!=1) {
						find=true;
					}
				}
			}
			
			//3. 세로줄 9칸 내 숫자 겹치는지 판별
			//세로 좌표는 고정, 가로가 달라짐
			for(int c=0; c<9; c++) {
				for(int i = 0; i<10; i++) {
					count[i] = 0;
				}
				for(int l=0; l<=8;l++) {
					int nr= l;
					count[sudoku[nr][c]]++;
					
				}
				for(int i =1; i<10; i++) {
					if(count[i]!=1) {
						find=true;
					}
				}
				
			}
			if(!find) {
				System.out.println("#"+test_case+" "+"1");
			}else {
				System.out.println("#"+test_case+" "+"0");
			}
		}
	}
}