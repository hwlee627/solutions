package 준홍이의카드놀이_sw_7102_3w;

import java.util.Arrays;
import java.io.FileInputStream;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			//카드N 배열 생성
			int[] cardN = new int [N];
			int indexN = 0;
			for(int i = 1; i <= N; i++) {
				cardN[indexN] = i;
				indexN++;
			}
			
			//카드M 배열 생성
			int[] cardM = new int [M];
			int indexM = 0;
			for(int i = 1; i <= M; i++) {
				cardM[indexM] = i;
				indexM++;
			}
//			System.out.println(Arrays.toString(cardN));
//			System.out.println(Arrays.toString(cardM));
			
			//두 카드 덱의 합의 횟수를 담을 합 카운트 배열 생성
			int[] sumCount = new int [N+M+1];
			
			//합을 인덱스로 해서 합 카운트 배열의 값을 1씩 올려주기
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					sumCount[cardN[i]+cardM[j]]++;
				}
			}
			
			int max = 0;
			//카운트배열에서 최대 횟수를 뽑아내기
			for(int i = 0; i<N+M+1; i++) {
				if(max < sumCount[i]) {
					max = sumCount[i];
				}
			}
			
			//중복일 경우도 있으므로
			//구한 최대 값을 배열 순회 돌려서
			//그 값을 담고있는 인덱스 값 (합) 출력
			System.out.print("#"+test_case);
			for(int i = 0; i<N+M+1; i++) {
				if(max == sumCount[i]) {
					System.out.print(" "+i+"\n");
				}
			}
		}
	}
}
