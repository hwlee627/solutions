package 회문2_sw_1216_2w;

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
		
		Scanner sc = new Scanner(System.in);
		int T=10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int testNumber = sc.nextInt();
			
			char[][] arr = new char[100][100];
			
			//배열 생성
			for(int r = 0; r<100; r++) {
				String str = sc.next();
				char[] line = str.toCharArray();
				for(int c = 0; c<100; c++) {
					arr[r][c] = line[c];
				}
			}
			
			//회문 찾기 용 2방향 델타 탐색 배열 생성 ( 우 // 하)
			int[] dr = {0,1};
			int[] dc = {1,0}; //우 하
			
			
			//회문 탐색
			int length = 0;
			int maxLength = 0;
			for(int r = 0; r<100; r++) {
				for(int c= 0; c<100; c++) {
					for(int d = 0; d<dr.length; d++) {
						for(int l = 0; l<100; l++) {
							int nr = r + dr[d]*l;
							int nc = c + dc[d]*l;
							
							//String 변수를 선언해 놓고
							//정방향 text 와 역방향 palindrome에 배열 값들을 넣어서
							//.equals로 비교
							
							String text = "";
							String palindrome = "";
							if(nr <=99 && nc <=99) {
								//우 탐색
								if(d == 0) {
									for(int i = c; i<=nc; i++) {
										text += arr[r][i];
									}
									for(int i = nc; i>=c; i--) {
										palindrome += arr[r][i];
									}
									//같다면, 그 때의 길이를 length라는 정수 변수에 넣어놓고
									if(text.equals(palindrome)) {
										length = text.length();
									}
								//하 탐색
								}else if(d == 1) {
									for(int i = r; i<=nr; i++) {
										text += arr[i][c];
									}
									for(int i = nr; i>=r; i--) {
										palindrome += arr[i][c];
									}
									if(text.equals(palindrome)) {
										length = text.length();
									}
								}
							}
							//length 중 최대의 length를 구하기 위해 maxlength 변수 선언
							if(maxLength < length) {
								maxLength = length;
							}
						}
					}
				}
			}
			System.out.println(maxLength);
			
		}
	}
}
